package com.ar4i.cats.presentation.splash.view;

import android.os.Bundle;
import android.widget.ImageView;

import com.ar4i.cats.R;
import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.base.presenter.MvpPresenter;
import com.ar4i.cats.presentation.base.view.BaseActivity;
import com.ar4i.cats.presentation.main.view.MainActivity;
import com.ar4i.cats.presentation.splash.presenter.SplashPresenter;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import butterknife.BindView;


public class SplashActivity extends BaseActivity implements SplashView {

    // region========================================UI=============================================

    @BindView(R.id.img_logo)
    ImageView imgLogo;

    // endregion-------------------------------------UI---------------------------------------------


    // region========================================LIFECYCLE======================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // endregion-------------------------------------LIFECYCLE--------------------------------------

    //==========================================start FIELDS========================================

    @Inject
    SplashPresenter splashPresenter;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start extends BaseActivity==========================

    @Override
    protected MvpPresenter getPresenter() { return splashPresenter; }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(MainActivity.getStartIntent(this));
    }

    @Override
    public void setLogoImage(String imageUrl) {
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_cat)
                .circleCrop()
                .error(R.drawable.ic_cat)
                .into(imgLogo);
    }

    //-------------------------------------------end extends BaseActivity---------------------------
}
