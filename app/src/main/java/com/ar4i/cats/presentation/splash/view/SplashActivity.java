package com.ar4i.cats.presentation.splash.view;

import android.os.Bundle;

import com.ar4i.cats.R;
import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.base.view.BaseActivity;
import com.ar4i.cats.presentation.splash.presenter.SplashPresenter;

import javax.inject.Inject;

import androidx.annotation.Nullable;


public class SplashActivity extends BaseActivity implements SplashView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        CatsApp.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    //==========================================start FIELDS========================================

    @Inject
    SplashPresenter splashPresenter;

    //-------------------------------------------end FIELDS-----------------------------------------


    //==========================================start extends BaseActivity==========================

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
