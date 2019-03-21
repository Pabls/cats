package com.ar4i.cats.presentation.base.presenter;

import com.ar4i.cats.presentation.base.view.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    //==========================================start FIELDS========================================

    private V mvpView;

    private CompositeDisposable compositeDisposable;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start implements MvpPresenter<MvpView>==============

    @Override
    public void attachView(V view) {
        this.mvpView = view;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.mvpView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

    //-------------------------------------------end implements MvpPresenter<MvpView>---------------

    //==========================================start PUBLIC METHODS================================

    public V getMvpView() {
        return this.mvpView;
    }

    public void track(Disposable disposable) {
        if (compositeDisposable != null) {
            compositeDisposable.add(disposable);
        }
    }

    //-------------------------------------------end PUBLIC METHODS---------------------------------
}

