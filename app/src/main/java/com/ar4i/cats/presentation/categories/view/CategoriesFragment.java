package com.ar4i.cats.presentation.categories.view;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ar4i.cats.R;
import com.ar4i.cats.presentation.base.presenter.MvpPresenter;
import com.ar4i.cats.presentation.base.view.BaseFragment;
import com.ar4i.cats.presentation.categories.presenter.CategoriesPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CategoriesFragment extends BaseFragment implements CategoriesView {

    public static CategoriesFragment newInstance() {
        return new CategoriesFragment();
    }

    // region========================================Fields=========================================

    @Inject
    CategoriesPresenter categoriesPresenter;

    // endregion-------------------------------------Fields-----------------------------------------


    // region========================================UI=============================================

    @BindView(R.id.sp_categories)
    Spinner spCategories;

    // endregion-------------------------------------UI---------------------------------------------


    // region========================================extends BaseFragment===========================

    @Override
    protected MvpPresenter getPresenter() {
        return categoriesPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_categories;
    }

    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    // endregion-------------------------------------extends BaseFragment---------------------------


    // region========================================implements CategoriesView======================

    @Override
    public void setCategoryNamesToSpinner(List<String> names) {
        String[] array = names.toArray(new String[names.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategories.setAdapter(adapter);
    }

    // endregion-------------------------------------implements CategoriesView----------------------

}