 package com.ecommerce.hashtagcollection.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecommerce.hashtagcollection.ProductDetailActivity;
import com.ecommerce.hashtagcollection.R;

public class GridAdapter extends BaseAdapter {
    int[] images;
    String[] titles;
    Context context;

    public GridAdapter(Context context, int[] images, String[] titles) {
        this.context = context;
        this.images = images;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false);
        ImageView ivGridImage = view.findViewById(R.id.ivGridImage);
        TextView tvGridTitle= view.findViewById(R.id.tvGridTitle);

        ivGridImage.setImageResource(images[position]);
        tvGridTitle.setText(titles[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("TITLE", titles[position]);
                intent.putExtra("IMAGE", images[position]);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
