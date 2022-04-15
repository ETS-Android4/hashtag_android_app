package com.ecommerce.hashtagcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ecommerce.hashtagcollection.database.SqliteDBHandler;
import com.ecommerce.hashtagcollection.model.TestCartModel;

public class ProductDetailActivity extends AppCompatActivity {
    private ImageView ivProductImage;
    private TextView tvProductTitle, topProductTitle, cartItems, tvProductDescription, tvProductPrice;
    private ImageButton increase, decrease;
    private Button addToCart;
    private boolean isFirstTimeinCart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().hide();
        topProductTitle = (TextView)findViewById(R.id.appTitle);
        ivProductImage = (ImageView)findViewById(R.id.ivProductImage);
        tvProductTitle = (TextView)findViewById(R.id.tvProductTitle);
        cartItems = (TextView)findViewById(R.id.tvChangedItem);
        tvProductDescription = (TextView)findViewById(R.id.tvDescription);
        tvProductPrice = (TextView) findViewById(R.id.tvProductPrice);
        decrease = (ImageButton)findViewById(R.id.ibDecrease);
        addToCart = (Button)findViewById(R.id.btAddToCart);
        registerUI();
    }

    private void registerUI() {
        Bundle extras = getIntent().getExtras();
        ivProductImage.setImageResource(extras.getInt("IMAGE"));
        tvProductTitle.setText(extras.getString("TITLE"));
        topProductTitle.setText(extras.getString("TITLE"));

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int items = Integer.parseInt(cartItems.getText().toString());
                items++;
                cartItems.setText(String.valueOf(items));
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int items = Integer.parseInt(cartItems.getText().toString());
                items--;
                cartItems.setText(String.valueOf(items));
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFirstTimeinCart) {
                    saveDataInLocal(new TestCartModel(0, topProductTitle.getText().toString(), tvProductDescription.getText().toString(), Integer.parseInt((String) cartItems.getText()), Integer.parseInt((String) tvProductPrice.getText()), Integer.parseInt(extras.getString("IMAGE"))));
                    Toast.makeText(ProductDetailActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveDataInLocal(TestCartModel cartModel) {
        SqliteDBHandler dbHandler = new SqliteDBHandler(this);
        long id = dbHandler.insertIntoCart(cartModel);


    }

}