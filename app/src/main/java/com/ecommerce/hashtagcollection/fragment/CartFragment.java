package com.ecommerce.hashtagcollection.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.hashtagcollection.R;
import com.ecommerce.hashtagcollection.adapter.CartAdapter;
import com.ecommerce.hashtagcollection.model.CartModel;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private RecyclerView recyclerCart;
    private CartAdapter cartAdapter;
    private ArrayList<CartModel> ourCartList = new ArrayList<CartModel>();

    private String TAG = "CartFragment";

    public CartFragment() {
        Log.d(TAG, "Chaleko xu hai ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        CartModel cart1 = new CartModel("1", "Jutta", 3, 3000, R.drawable.pic1, 13, 1000);
        CartModel cart2 = new CartModel("2", "Khelauna", 4, 4000, R.drawable.pic2, 23,300 );
        CartModel cart3 = new CartModel("3", "Moi", 5, 5000, R.drawable.pic3, 5, 50);
        CartModel cart4 = new CartModel("4", "Sugako pwakh", 7, 6000, R.drawable.pic4, 12, 3000);
        CartModel cart5 = new CartModel("5", "Mero Majjan", 6, 8000, R.drawable.pic5, 5, 70);
        CartModel cart6 = new CartModel("6", "Maile lako aauthi", 7, 9000, R.drawable.pic6, 9, 50000);
        CartModel cart7 = new CartModel("7", "C++", 8, 3000, R.drawable.pic7, 16, 400);
        CartModel cart8 = new CartModel("8", "Java", 9, 4500, R.drawable.pic8, 18, 500);

        ourCartList.add(cart1);
        ourCartList.add(cart2);
        ourCartList.add(cart3);
        ourCartList.add(cart4);
        ourCartList.add(cart5);
        ourCartList.add(cart6);
        ourCartList.add(cart7);
        ourCartList.add(cart8);

        cartAdapter = new CartAdapter(ourCartList, getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_cart,container, false);
        recyclerCart = (RecyclerView) view.findViewById(R.id.recyclerCart);
        recyclerCart.setHasFixedSize(true);
        recyclerCart.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerCart.setAdapter(cartAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "ONViewCreated");
    }
}
