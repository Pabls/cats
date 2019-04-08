package com.ar4i.cats.presentation.favorite.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar4i.cats.R;

import androidx.fragment.app.Fragment;

public class FavoriteFragment extends Fragment {

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
}