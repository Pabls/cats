package com.ar4i.cats.presentation.splash.presenter;

import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.splash.view.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

//    CategoriesRepository categoriesRepository;
//
//    public SplashPresenter(CategoriesRepository categoriesRepository) {
//        this.categoriesRepository = categoriesRepository;
//    }

    @Override
    public void attachView(SplashView view) {

        super.attachView(view);
        //getCategories();

        track(Observable.just(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(res -> {
                    getMvpView().navigateToMainScreen();
                }));
    }

//    private void getCategories() {
//        if (categoriesRepository != null) {
//            track(categoriesRepository.getCategories()
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(res -> {
//                        int a = 1;
//                    }, err -> {
//                        getMvpView().showMessage(err.getMessage());
//                    }));
//
//        }
//
//    }
}
