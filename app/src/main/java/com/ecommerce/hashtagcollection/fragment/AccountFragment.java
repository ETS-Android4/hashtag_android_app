package com.ecommerce.hashtagcollection.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ecommerce.hashtagcollection.Constants;
import com.ecommerce.hashtagcollection.Login_Activity;
import com.ecommerce.hashtagcollection.R;

import org.w3c.dom.Text;

public class AccountFragment extends Fragment {

    private TextView greetMe;
    private Button logout;
    private String TAG = "AccoutFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account,container, false);
        greetMe = (TextView) view.findViewById(R.id.greetMe);
        logout = (Button) view.findViewById(R.id.logout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Constants.HASH_TAG_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(Constants.EMAIL, "");
        greetMe.setText("Welcome " +username + " in our HasTagCollection.");
        logout.setOnClickListener(thisview->{
            Log.d(TAG, "clicked logout botton");
            Intent intent = new Intent(getActivity(), Login_Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            sharedPreferences.edit().putBoolean(Constants.IS_LOGIN, false).apply();
            getActivity().startActivity(intent);
        });
    }
}
