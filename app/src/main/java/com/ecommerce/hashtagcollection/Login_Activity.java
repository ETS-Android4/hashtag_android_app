package com.ecommerce.hashtagcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText email, password , signIn;
    Button login;
    private String TAG = "LOGINACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.HASH_TAG_SHARED_PREFERENCES, MODE_PRIVATE);

        Log.d(TAG, sharedPreferences.getBoolean(Constants.IS_LOGIN, false) + " : isLogin ?");
        if(sharedPreferences.getBoolean(Constants.IS_LOGIN, false)) {
            goToMainAcitivity();
        }

        email = (EditText) findViewById(R.id.etEmailLogin);
        password = (EditText) findViewById(R.id.etPasswordLogin);
        signIn = (EditText) findViewById(R.id.etSignIn);
        login = (Button) findViewById(R.id.btnLogin);

        if(email.length() > 0 ) {
            sharedPreferences.edit().putString(Constants.EMAIL, email.toString()).apply();
        }
        if(password.length() > 0) {
            sharedPreferences.edit().putString(Constants.PASSWORD, password.toString()).apply();
        }

        login.setOnClickListener(view-> {
            Log.d(TAG, "Login btn clicked");
            if(email.getText().toString().equals("Bibash Rana")&& password.getText().toString().equals("abcd")) {
                sharedPreferences.edit().putBoolean(Constants.IS_LOGIN, true).apply();
                sharedPreferences.edit().putString(Constants.EMAIL, email.getText().toString()).apply();
                Log.d(TAG, sharedPreferences.getBoolean(Constants.IS_LOGIN, false) + " : isLogin ?");
                goToMainAcitivity();
            } else{
                Toast.makeText(this, "Email or password incorrect.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private  void goToMainAcitivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}