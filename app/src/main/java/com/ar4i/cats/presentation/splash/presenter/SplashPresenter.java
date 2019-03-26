package com.ar4i.cats.presentation.splash.presenter;

import com.ar4i.cats.data.repositories.CategoriesRepository;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.splash.view.SplashView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

    CategoriesRepository categoriesRepository;

    public SplashPresenter(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public void attachView(SplashView view) {

        super.attachView(view);
        getCategories();
    }

    private void getCategories() {
        if (categoriesRepository != null) {
            track(categoriesRepository.getCategories()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(res -> {
                        int a = 1;
                    }, err -> {
                        getMvpView().showMessage(err.getMessage());
                    }));

        }

    }
}
