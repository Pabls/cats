package com.ar4i.cats.presentation.splash.view;

import com.ar4i.cats.presentation.base.view.MvpView;

public interface SplashView extends MvpView {
    void navigateToMainScreen();
    void setLogoImage(String imageUrl);
    void showNoNetworkMessage(boolean show);
}
