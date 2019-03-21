package com.ar4i.cats.presentation.splash.view;

import android.annotation.SuppressLint;

import com.ar4i.cats.R;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.base.view.BaseActivity;
import com.ar4i.cats.presentation.base.view.MvpView;
import com.ar4i.cats.presentation.splash.presenter.SplashPresenter;


public class SplashActivity extends BaseActivity implements SplashView {

    //==========================================start FIELDS========================================


    SplashPresenter splashPresenter = new SplashPresenter();

    //-------------------------------------------end FIELDS-----------------------------------------


    //==========================================start extends BaseActivity==========================

    @Override
    protected void createPresenter() {
    }

    @SuppressWarnings("unchecked")
    @Override
    protected BasePresenter getPresenter() {
        return this.splashPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    //-------------------------------------------end extends BaseActivity---------------------------
}
