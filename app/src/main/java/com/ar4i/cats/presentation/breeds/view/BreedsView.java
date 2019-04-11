package com.ar4i.cats.presentation.breeds.view;

import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.presentation.base.view.MvpView;

import java.util.List;

import io.reactivex.Observable;

public interface BreedsView extends MvpView {
    Observable<Integer> onSpinnerItemSelection();
    void setBreedNamesToSpinner(List<String> names);
    void showBreedInfo(Breed breed, String flagApiUrl);
    void showBreedImg(String imgUrl);
}
