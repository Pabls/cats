package com.ar4i.cats.presentation.breeds.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.ar4i.cats.R;
import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.presentation.base.presenter.BasePresenter;
import com.ar4i.cats.presentation.base.view.BaseFragment;
import com.ar4i.cats.presentation.breeds.presenter.BreedsPresenter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;

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
    public void setBreedNamesToSpinner(List<String> names) {
        String[] array = names.toArray(new String[names.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBreeds.setAdapter(adapter);
    }

    // endregion-------------------------------------extends BaseFragment---------------------------

}
