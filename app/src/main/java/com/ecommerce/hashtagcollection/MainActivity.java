package com.ecommerce.hashtagcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ecommerce.hashtagcollection.fragment.AccountFragment;
import com.ecommerce.hashtagcollection.fragment.CartFragment;
import com.ecommerce.hashtagcollection.fragment.FavoriteFragment;
import com.ecommerce.hashtagcollection.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout flFragment;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    //creating instances of fragement
    final Fragment homeFragment = new HomeFragment();
    final Fragment favoritesFragment = new FavoriteFragment();
    final Fragment cartFragment = new CartFragment();
    final Fragment accountFragment = new AccountFragment();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        flFragment = (FrameLayout) findViewById(R.id.flFragment);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        fragmentManager = getSupportFragmentManager();

        //hide others fragments besides home fragment
        fragmentManager.beginTransaction().add(R.id.flFragment, favoritesFragment, "fravoritesFragment").hide(favoritesFragment).commit();
        fragmentManager.beginTransaction().add(R.id.flFragment, cartFragment, "cartFragment").hide(cartFragment).commit();
        fragmentManager.beginTransaction().add(R.id.flFragment, accountFragment, "accountFragment").hide(accountFragment).commit();
        fragmentManager.beginTransaction().add(R.id.flFragment, homeFragment, "homeFragment").commit();

        NavigationBarView.OnItemSelectedListener onItemSelectedListener = item -> {
            switch (item.getItemId()) {
                case R.id.navHome:
                    fragmentManager.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    return true;

                case R.id.navFavorites:
                    fragmentManager.beginTransaction().hide(active).show(favoritesFragment).commit();
                    active = favoritesFragment;
                    return true;

                case R.id.navCart:
                    fragmentManager.beginTransaction().hide(active).show(cartFragment).commit();
                    active = cartFragment;
                    return true;

                case R.id.navAccount:
                    fragmentManager.beginTransaction().hide(active).show(accountFragment).commit();
                    active = accountFragment;
                    return true;
            }
            return false;
        };
        bottomNavigationView.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

//   private void setCurrentFragment(Fragment fragment) {
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.flFragment, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//   }
