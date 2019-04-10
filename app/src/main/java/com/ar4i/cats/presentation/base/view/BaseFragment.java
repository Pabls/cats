package com.ar4i.cats.presentation.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements MvpView {

    // region========================================LIFECYCLE======================================


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if(getPresenter() != null)
        getPresenter().attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detachView();
    }

    // endregion-------------------------------------LIFECYCLE--------------------------------------

    //==========================================start implements MvpView============================

    @Override
    public void showMessage(String message) {
        Toast.makeText(this.getActivity(), message, Toast.LENGTH_SHORT).show();
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
