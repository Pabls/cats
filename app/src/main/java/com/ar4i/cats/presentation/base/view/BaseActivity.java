package com.ar4i.cats.presentation.base.view;

import android.os.Bundle;
import android.widget.Toast;

import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    //==========================================start LIFECYCLE=====================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        ButterKnife.bind(this);

        getPresenter().attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }

    //-------------------------------------------end LIFECYCLE--------------------------------------

    //==========================================start implements MvpView============================

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //-------------------------------------------end -----------------------------------------------

    //==========================================start PROTECTED METHODS=============================

    protected ApplicationComponent getComponent() {
        return CatsApp.getApplicationComponent();
    }

    //-------------------------------------------end PROTECTED METHODS------------------------------

    //==========================================start ABSTRACT METHODS==============================

    protected abstract BasePresenter<MvpView> getPresenter();

    protected abstract int getLayoutId();

    protected abstract void inject();

    //-------------------------------------------end ABSTRACT METHODS-------------------------------

}
