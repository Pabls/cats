package com.ar4i.cats.presentation.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ar4i.cats.R;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.base.view.BaseActivity;
import com.ar4i.cats.presentation.breeds.view.BreedsFragment;
import com.ar4i.cats.presentation.categories.view.CategoriesFragment;
import com.ar4i.cats.presentation.favorite.view.FavoriteFragment;
import com.ar4i.cats.presentation.main.presenter.MainPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }


    // region========================================FIELDS=========================================

    MainPresenter mainPresenter = new MainPresenter();

    // endregion-------------------------------------FIELDS-----------------------------------------



    // region========================================UI=============================================

    @BindView(R.id.bnv_nav)
    BottomNavigationView bnvView;

    // endregion-------------------------------------UI---------------------------------------------



    //==========================================start Lifecycle=====================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initNavigation();

        if (savedInstanceState == null) {
            showFragment(BreedsFragment.newInstance());
        }
    }

    //-------------------------------------------end Lifecycle--------------------------------------



    //==========================================start extends BaseActivity==========================

    @Override
    protected BasePresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void inject() {

    }

    //-------------------------------------------end extends BaseActivity---------------------------

    // region========================================PRIVATE METHODS================================

    private void initNavigation() {
        if (bnvView != null) {
            bnvView.setOnNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.action_bottom_navigation_breeds:
                        showFragment(BreedsFragment.newInstance());
                        break;
                    case R.id.action_bottom_navigation_categories:
                        showFragment(CategoriesFragment.newInstance());
                        break;
                    case R.id.action_bottom_navigation_favorites:
                        showFragment(FavoriteFragment.newInstance());
                        break;
                    default:
                        break;
                }
                return true;
            });
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }

    // endregion-------------------------------------PRIVATE METHODS--------------------------------

}
