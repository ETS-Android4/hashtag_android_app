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
import com.ecommerce.hashtagcollection.model.TestCartModel;

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
        //Database bata data lyani ani testCartModels lai varni, balla girdview ma dekhaune
        //API le garxa....front end ko kaam Android Studiio...backend, database, ma data lai lyaune kaam API url le garxa
        //payment: khalti, esewa, API for payment. facebook.com just show garne web page.....apile chai Database saga bolxa, create row
        //garna , delete....
        // Esewako api for payment: http://esewa.com/paymoney , parameter (100,985494949, 93838383839)...
        //successs: if(success)= you have successfuly made payment...else = something went wrong, try again.
        //hack vayo esewa: http://esewa.com/sendMoney, parameter(1000, 38388383,8383838)
        //hack vayo fb: http://fb.com/doLike , parameter(kasle, kaslai)
        //user dekhaune: 2398293498
        //system
        //favorate: http://hashtagcollection.com/getFavoraties
        //favorite add: http://hashtagcollection.com/addFavorties , parameter(int userId, int productId)


        //private void paymoney(int tirnePaisa, String kasletirne, String kasleTireko){
         //database add
            //return sucess or failure
        // }


        List<TestCartModel> testCartModels = new ArrayList<>();
        TestCartModel kaloChasma = new TestCartModel(1,"KaloChasma","ramro xa",10,1000,R.drawable.pic1);
        testCartModels.add(kaloChasma);
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic1));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic2));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic3));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic4));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic5));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic6));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic7));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic8));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic9));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic10));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic11));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic12));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic13));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic14));
        testCartModels.add(new TestCartModel(0, "Chasma New ", "Mero new Chasma ho yr.", 50, 1000,R.drawable.pic15));

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
