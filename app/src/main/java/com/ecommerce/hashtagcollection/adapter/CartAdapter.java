package com.ecommerce.hashtagcollection.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.hashtagcollection.R;
import com.ecommerce.hashtagcollection.model.CartModel;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyCartViewHolder> {
    private ArrayList<CartModel> ourCartList;
    private Context context;
    private String TAG = "CART_ADAPTER";

    public CartAdapter(ArrayList<CartModel> ourCartList, Context context) {
        this.ourCartList = ourCartList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        MyCartViewHolder myCartViewHolder = new MyCartViewHolder(view);
        return myCartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
        CartModel singleCartModel = ourCartList.get(position);
        holder.cartTitle.setText(singleCartModel.getProductTitle());
        holder.cartImage.setImageResource(singleCartModel.getProductImage());
        int productRealPrice = singleCartModel.getProductPerItemPrice() * singleCartModel.getProductItems();
        holder.cartPaisa.setText( productRealPrice+ "");
        holder.cartItems.setText(singleCartModel.getProductItems() + "");

        deleteCartItem(holder.cartDelete, position);
        increaseItems(holder.cartIncrease, holder.cartItems, position, singleCartModel.getProductInStock(), holder.cartPaisa);
        decreseItems(holder.cartDecrease, holder.cartItems, position);

    }

    @Override
    public int getItemCount() {
        return ourCartList.size();
    }

    private void deleteCartItem(Button cartDelete, int position) {
        cartDelete.setOnClickListener(view -> {
            Log.d(TAG, "cart delete cliked ");
            ourCartList.remove(position);
            Toast.makeText(context, "Deleted Successfully.", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        });
    }

    private void increaseItems(ImageButton cartIncrease,
                               TextView cartItems, int position, int productInStock, TextView cartPaisa) {

        cartIncrease.setOnClickListener(view -> {
            Log.d(TAG, "cart increased ");
            int pahilaKoItems = ourCartList.get(position).getProductItems(); //4, 24, 25
            int pahilaKatiPaisaTyo = ourCartList.get(position).getProductPerItemPrice();

            int aaileKoItems = 0; //0

            if (pahilaKoItems < productInStock) { //4 > 25 , 24> 25 , 25>25
                aaileKoItems = pahilaKoItems + 1; //4+1, 24+1 , chaldena yr
                ourCartList.get(position).setProductItems(aaileKoItems); //5, 24+1, chaldena yr
                cartItems.setText(ourCartList.get(position).getProductItems() + ""); //show 5, show 24+1, chaldena yr
                cartPaisa.setText((pahilaKatiPaisaTyo * aaileKoItems) + "");
            }

        });
    }

    private void decreseItems(ImageButton cartDecrease, TextView cartItems, int position) {
        cartDecrease.setOnClickListener(view -> {
            Log.d(TAG, "cart decrease");
            int pahilaKoItems = ourCartList.get(position).getProductItems();
            ourCartList.get(position).setProductItems(pahilaKoItems - 1);
            cartItems.setText(ourCartList.get(position).getProductItems() + "");

            /**
             * TODO: gharma you gara laa decrease garne haih
             * -teti khera decrease nagar jati khera item 1 hunxa
             * -price pani gatau
             */

        });
    }

    static final class MyCartViewHolder extends RecyclerView.ViewHolder {
        private final TextView cartTitle;
        private final ImageView cartImage;
        private final ImageButton cartIncrease;
        private final ImageButton cartDecrease;
        private final Button cartUpdate;
        private final Button cartDelete;
        private final TextView cartPaisa;
        private final TextView cartItems;
        private String TAG = "CART_ADAPTER";

        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartTitle = (TextView) itemView.findViewById(R.id.cartTitle);
            cartImage = (ImageView) itemView.findViewById(R.id.cartImage);
            cartDecrease = (ImageButton) itemView.findViewById(R.id.cartDecrease);
            cartIncrease = (ImageButton) itemView.findViewById(R.id.cartIncrease);
            cartUpdate = (Button) itemView.findViewById(R.id.cartUpdate);
            cartDelete = (Button) itemView.findViewById(R.id.cartDelete);
            cartPaisa = (TextView) itemView.findViewById(R.id.cartPaisa);
            cartItems = (TextView) itemView.findViewById(R.id.cartItems);
        }
    }
}
