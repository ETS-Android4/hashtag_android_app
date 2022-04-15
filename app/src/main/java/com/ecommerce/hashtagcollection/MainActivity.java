package com.ecommerce.hashtagcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        flFragment = (FrameLayout)findViewById(R.id.flFragment);
        bottomNavigationView  = (BottomNavigationView)findViewById(R.id.bottomNav);

        fragmentManager = getSupportFragmentManager();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()) {
                    case R.id.navHome:
                        fragment = new HomeFragment();
                        break;
                    case R.id.navFavorites:
                        fragment = new FavoriteFragment();
                        break;
                    case R.id.navCart:
                        fragment = new CartFragment();
                        break;
                    case R.id.navAccount:
                        fragment = new AccountFragment();
                        break;
                    default:
                        break;
                }
                setCurrentFragment(fragment);
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.navHome);
    }

   private void setCurrentFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
   }
}