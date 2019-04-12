package com.ar4i.cats.presentation.breeds.view;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.ar4i.cats.R;
import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.base.view.BaseFragment;
import com.ar4i.cats.presentation.breeds.presenter.BreedsPresenter;
import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding2.widget.RxAdapterView;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import io.reactivex.Observable;

public class BreedsFragment extends BaseFragment implements BreedsView {

    public static BreedsFragment newInstance() {
        return new BreedsFragment();
    }

    // region========================================UI=============================================

    @BindView(R.id.sp_breeds)
    Spinner spBreeds;

    @BindView(R.id.img_breed_photo)
    ImageView imgBreedPhoto;

    @BindView(R.id.tv_breed_name)
    TextView tvBreedName;

    @BindView(R.id.img_country_flag)
    ImageView imgCountryFlag;

    @BindView(R.id.tv_life_span)
    TextView tvLifeSpan;

    @BindView(R.id.tv_weight)
    TextView tvWeight;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.rb_affection_lvl)
    RatingBar rbAffectionLvl;

    @BindView(R.id.rb_adaptability)
    RatingBar rbAdaptability;

    @BindView(R.id.rb_child_friendly)
    RatingBar rbChildFriendly;

    @BindView(R.id.rb_dog_friendly)
    RatingBar rbDogFriendly;

    @BindView(R.id.rb_energy_lvl)
    RatingBar rbEnergylvl;

    @BindView(R.id.rb_grooming)
    RatingBar rbGrooming;

    @BindView(R.id.rb_health_issues)
    RatingBar rbHealth;

    @BindView(R.id.rb_intelligence)
    RatingBar rbIntelligence;

    @BindView(R.id.rb_shedding_lvl)
    RatingBar rbSheddingLvl;

    @BindView(R.id.rb_social_needs)
    RatingBar rbSocialNeeds;

    @BindView(R.id.rb_stranger_friendly)
    RatingBar rbStarngerFriendly;

    @BindView(R.id.rb_vocalisation)
    RatingBar rbVocalisation;

    // endregion-------------------------------------UI---------------------------------------------

    // region========================================FIELDS=========================================

    @Inject
    BreedsPresenter breedsPresenter;

    // endregion-------------------------------------FIELDS-----------------------------------------

    // region========================================LIFECYCLE======================================

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    // endregion-------------------------------------LIFECYCLE--------------------------------------

    // region========================================extends BaseFragment===========================

    @Override
    protected BasePresenter getPresenter() {
        return breedsPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_breeds;
    }

    @Override
    protected void inject() {
        getComponent().inject(this);
    }

    @Override
    public Observable<Integer> onSpinnerItemSelection() {
        return RxAdapterView.itemSelections(spBreeds).map(index -> index);
    }

    @Override
    public void setBreedNamesToSpinner(List<String> names) {
        String[] array = names.toArray(new String[names.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBreeds.setAdapter(adapter);
    }

    @Override
    public void showBreedInfo(Breed breed, String flagApiUrl) {
        tvBreedName.setText(breed.getName());
        tvDescription.setText(breed.getDescription());
        tvLifeSpan.setText(breed.getLifeSpan());
        tvWeight.setText(breed.getWeight().getMetric());
        rbAdaptability.setNumStars(breed.getAdaptability());
        rbAffectionLvl.setNumStars(breed.getAffectionLevel());
        rbChildFriendly.setNumStars(breed.getChildFriendly());
        rbDogFriendly.setNumStars(breed.getDogFriendly());
        rbEnergylvl.setNumStars(breed.getEnergyLevel());
        rbGrooming.setNumStars(breed.getGrooming());
        rbHealth.setNumStars(breed.getHealthIssues());
        rbIntelligence.setNumStars(breed.getIntelligence());
        rbSheddingLvl.setNumStars(breed.getSheddingLevel());
        rbSocialNeeds.setNumStars(breed.getSocialNeeds());
        rbStarngerFriendly.setNumStars(breed.getStrangerFriendly());
        rbVocalisation.setNumStars(breed.getVocalisation());

        Glide.with(this)
                .load(flagApiUrl)
                .into(imgCountryFlag);
    }

    @Override
    public void showBreedImg(String imgUrl) {
        Glide.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.ic_cat)
                .error(R.drawable.ic_cat)
                .into(imgBreedPhoto);
    }

    // endregion-------------------------------------extends BaseFragment---------------------------
}
