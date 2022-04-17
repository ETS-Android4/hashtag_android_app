package com.ecommerce.hashtagcollection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.hashtagcollection.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyCartViewHolder> {


    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        MyCartViewHolder myCartViewHolder = new MyCartViewHolder(view);
        return myCartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    final class MyCartViewHolder extends RecyclerView.ViewHolder {

        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
