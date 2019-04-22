package com.ar4i.cats.presentation.categories.view;

import com.ar4i.cats.presentation.base.view.MvpView;

import java.util.List;

public interface CategoriesView extends MvpView {
    void setCategoryNamesToSpinner(List<String> names);
}
