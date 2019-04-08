package com.ar4i.cats.presentation.categories.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar4i.cats.R;

import androidx.fragment.app.Fragment;

public class CategoriesFragment extends Fragment {

    public static CategoriesFragment newInstance() {
        return new CategoriesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }
}