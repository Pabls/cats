package com.ar4i.cats.presentation.base.presenter;

import com.ar4i.cats.presentation.base.view.MvpView;

public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    void detachView();
}

