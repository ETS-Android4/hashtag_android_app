package com.ecommerce.hashtagcollection.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ecommerce.hashtagcollection.R;
import com.ecommerce.hashtagcollection.adapter.GridAdapter;
import com.ecommerce.hashtagcollection.model.CartModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private GridView gridViewHome;
    private GridAdapter gridAdapter;
    private int[] images = new int[14];
    private String[] titles = new String[14];


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        gridViewHome = (GridView) view.findViewById(R.id.gridViewHome);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareData();
        settingAdapter();
    }

    private void prepareData() {
        for(int i = 0; i<14; i++) {
            images[i] = R.drawable.pic1;
            titles[i] = "Product";
        }
    }

    private void settingAdapter() {
        gridAdapter = new GridAdapter(getContext(),images,titles);
        gridViewHome.setAdapter(gridAdapter);
    }

}
