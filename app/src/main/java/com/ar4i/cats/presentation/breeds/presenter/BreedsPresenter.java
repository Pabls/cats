package com.ar4i.cats.presentation.breeds.presenter;

import com.ar4i.cats.domain.interactors.breeds.IBreedsInteractor;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.breeds.view.BreedsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BreedsPresenter extends BasePresenter<BreedsView> {

    @Inject
    public BreedsPresenter(IBreedsInteractor mIBreedsInteractor) {
        this.iBreedsInteractor = mIBreedsInteractor;
    }

    // region========================================FIELDS=========================================

    private IBreedsInteractor iBreedsInteractor;

    // endregion-------------------------------------FIELDS-----------------------------------------

    // region========================================extends BasePresenter<BreedsView>==============

    @Override
    public void attachView(BreedsView view) {
        super.attachView(view);
        getBreedNames();
    }

    // endregion-------------------------------------extends BasePresenter<BreedsView>--------------

    // region========================================PRIVATE METHODS================================

    private void getBreedNames() {
        track(this.iBreedsInteractor.getBreedNames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(names -> {
                    List<String> list = new ArrayList<>();
                    list.add("as");
                    list.add("as2");
                    getMvpView().setBreedNamesToSpinner(list);
                }, error -> {

                }));
    }

    // endregion-------------------------------------PRIVATE METHODS--------------------------------
}
