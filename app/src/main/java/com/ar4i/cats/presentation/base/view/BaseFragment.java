package com.ar4i.cats.presentation.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ar4i.cats.R;
import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.presentation.base.presenter.MvpPresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements MvpView {

    // region========================================UI=============================================

    FrameLayout rootLayout;

    // endregion-------------------------------------UI---------------------------------------------

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

        rootLayout = getActivity().findViewById(android.R.id.content);
        if (getPresenter() != null)
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

    @Override
    public void showLoad() {
        View.inflate(getActivity(), R.layout.view_progress, rootLayout);
    }

    @Override
    public void hideLoad() {
        if (rootLayout != null)
            rootLayout.removeViewAt(rootLayout.getChildCount() - 1);
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
