package com.ar4i.cats.presentation.base.view;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ar4i.cats.R;
import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.presentation.base.presenter.MvpPresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    // region========================================UI=============================================

    @BindView(android.R.id.content)
    FrameLayout flRoot;

    // endregion-------------------------------------UI---------------------------------------------

    //==========================================start LIFECYCLE=====================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();

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

    @Override
    public void showLoad() {
        View.inflate(this, R.layout.view_progress, flRoot);
    }

    @Override
    public void hideLoad() {
        if (flRoot != null)
            flRoot.removeViewAt(flRoot.getChildCount() - 1);
    }

    //-------------------------------------------end -----------------------------------------------

    //==========================================start PROTECTED METHODS=============================

    protected ApplicationComponent getComponent() {
        return CatsApp.getApplicationComponent();
    }

    //-------------------------------------------end PROTECTED METHODS------------------------------

    //==========================================start ABSTRACT METHODS==============================

    protected abstract MvpPresenter<MvpView> getPresenter();

    protected abstract int getLayoutId();

    protected abstract void inject();

    //-------------------------------------------end ABSTRACT METHODS-------------------------------

}
