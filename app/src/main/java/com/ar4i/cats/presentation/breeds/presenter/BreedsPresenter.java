package com.ar4i.cats.presentation.breeds.presenter;

import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.domain.interactors.breeds.IBreedsInteractor;
import com.ar4i.cats.domain.interactors.images.ImagesInteractor;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.breeds.view.BreedsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BreedsPresenter extends BasePresenter<BreedsView> {

    @Inject
    public BreedsPresenter(IBreedsInteractor mIBreedsInteractor, ImagesInteractor imagesInteractor) {
        this.iBreedsInteractor = mIBreedsInteractor;
        this.imagesInteractor = imagesInteractor;
    }

    // region========================================FIELDS=========================================

    private IBreedsInteractor iBreedsInteractor;
    private ImagesInteractor imagesInteractor;
    List<PartialBreedModel> partialBreedModels = new ArrayList<>();
    List<String> breedNames = new ArrayList<>();

    // endregion-------------------------------------FIELDS-----------------------------------------

    // region========================================extends BasePresenter<BreedsView>==============

    @Override
    public void attachView(BreedsView view) {
        super.attachView(view);
        getBreedModels();
        track(getMvpView().onSpinnerItemSelection()
                .subscribe(index -> {
                    if (!this.partialBreedModels.isEmpty()){
                        getBreedByName(this.partialBreedModels.get(index).getName());
                        getImageByBreedId(this.partialBreedModels.get(index).getId());
                    }
                }, throwable -> getMvpView().showMessage(throwable.getMessage())));
    }

    // endregion-------------------------------------extends BasePresenter<BreedsView>--------------

    // region========================================PRIVATE METHODS================================

    private void getBreedModels() {
        track(this.iBreedsInteractor.getBreedModels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(_void -> getMvpView().showLoad())
                .doOnEvent((res, error) -> getMvpView().hideLoad())
                .subscribe(partialBreedModels -> {
                    if (partialBreedModels != null && !partialBreedModels.isEmpty()) {
                        this.partialBreedModels = partialBreedModels;
                        getBreedByName(this.partialBreedModels.get(0).getName());
                        getImageByBreedId(this.partialBreedModels.get(0).getId());
                        getBreedNames(partialBreedModels);
                    }
                }, throwable -> getMvpView().showMessage(throwable.getMessage())));
    }

    private void getBreedNames(List<PartialBreedModel> models) {
        track(this.iBreedsInteractor.getBreedNames(models)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(names -> {
                    this.breedNames = names;
                    getMvpView().setBreedNamesToSpinner(names);
                }, throwable -> getMvpView().showMessage(throwable.getMessage())));
    }

    private void getBreedByName(String name) {
        track(this.iBreedsInteractor.getBreedByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(_void -> getMvpView().showLoad())
                .doOnEvent((res, error) -> getMvpView().hideLoad())
                .subscribe(breed -> {
                    if (breed != null) {
                        getMvpView().showBreedInfo(breed, getFlagApiUrl(breed));
                    }
                }, throwable -> getMvpView().showMessage(throwable.getMessage())));
    }

    private void getImageByBreedId(String breedId) {
        track(this.imagesInteractor.getImageByBreedId(breedId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(imgUrl -> {
                    if (imgUrl != null && !imgUrl.isEmpty()) {
                        getMvpView().showBreedImg(imgUrl);
                    }
                }, throwable -> getMvpView().showMessage(throwable.getMessage())));
    }

    private String getFlagApiUrl(Breed breed) {
        String flagApiUrl = "https://www.countryflags.io/%s/flat/64.png";
        return String.format(flagApiUrl, breed.getCountryCode());
    }

    // endregion-------------------------------------PRIVATE METHODS--------------------------------
}
