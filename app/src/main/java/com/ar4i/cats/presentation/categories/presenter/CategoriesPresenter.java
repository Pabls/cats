package com.ar4i.cats.presentation.categories.presenter;

import com.ar4i.cats.data.models.CategoryModel;
import com.ar4i.cats.domain.interactors.categories.ICategoriesInteractor;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.categories.view.CategoriesView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CategoriesPresenter extends BasePresenter<CategoriesView> {

    public CategoriesPresenter(ICategoriesInteractor iCategoriesInteractor) {
        this.iCategoriesInteractor = iCategoriesInteractor;
    }

    // region========================================Fields=========================================

    private ICategoriesInteractor iCategoriesInteractor;
    private List<CategoryModel> categoryModels = new ArrayList<>();
    private List<String> categoryNames = new ArrayList<>();

    // endregion-------------------------------------Fields-----------------------------------------

    // region========================================extends BasePresenter<CategoriesView>==========

    @Override
    public void attachView(CategoriesView view) {
        super.attachView(view);
        getCategories();
    }

    // endregion-------------------------------------extends BasePresenter<CategoriesView>----------


    // region========================================Private methods================================

    private void getCategories() {
        track(iCategoriesInteractor.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(_void -> getMvpView().showLoad())
                .doOnEvent((categoryModels, throwable) -> getMvpView().hideLoad())
                .subscribe(models -> {
                    if (models != null) {
                        categoryModels = models;
                        getCategoryNames(models);
                    }
                }, error -> {

                }));
    }

    private void getCategoryNames(List<CategoryModel> categoryModels) {
        track(iCategoriesInteractor.getCategoryNames(categoryModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(_void -> getMvpView().showLoad())
                .doOnEvent((strings, throwable) -> getMvpView().hideLoad())
                .subscribe(names -> {
                    if (names != null) {
                        categoryNames = names;
                        getMvpView().setCategoryNamesToSpinner(names);
                    }
                }, error -> {
                }));
    }

    // endregion-------------------------------------Private methods--------------------------------
}
