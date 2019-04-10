package com.ar4i.cats.presentation.breeds.view;

import com.ar4i.cats.presentation.base.view.MvpView;

import java.util.List;

public interface BreedsView extends MvpView {
    void setBreedNamesToSpinner(List<String> names);
}
