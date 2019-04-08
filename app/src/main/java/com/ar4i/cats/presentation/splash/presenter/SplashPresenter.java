package com.ar4i.cats.presentation.splash.presenter;

import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.splash.view.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

    @Override
    public void attachView(SplashView view) {
        super.attachView(view);
        track(Observable.just(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(5000, TimeUnit.MILLISECONDS)
                .subscribe(res -> {
                    getMvpView().navigateToMainScreen();
                }));
    }
}
