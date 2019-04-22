package com.ar4i.cats.presentation.splash.presenter;

import com.ar4i.cats.domain.interactors.images.IImagesInteractor;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.splash.view.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

    // region========================================FIELDS=========================================

    private IImagesInteractor iImagesInteractor;

    // endregion-------------------------------------FIELDS-----------------------------------------

    public SplashPresenter(IImagesInteractor iImagesInteractor) {
        this.iImagesInteractor = iImagesInteractor;
    }

    // region========================================extends BasePresenter<SplashView>==============

    @Override
    public void attachView(SplashView view) {
        super.attachView(view);
        initLogo();
    }

    // endregion-------------------------------------extends BasePresenter<SplashView>--------------


    // region========================================PRIVATE METHODS================================

    private void initLogo() {
        track(this.iImagesInteractor.getRandomImageUrl()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(url -> {
                    if (url != null && !url.isEmpty()) {
                        getMvpView().setLogoImage(url);
                        navigateToApp();
                    }
                }, error -> {
                    navigateToApp();
                }));
    }

    private void navigateToApp(){
        track(Observable.just(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(2000, TimeUnit.MILLISECONDS)
                .subscribe(res -> getMvpView().navigateToMainScreen()));
    }

    // endregion-------------------------------------PRIVATE METHODS--------------------------------
}
