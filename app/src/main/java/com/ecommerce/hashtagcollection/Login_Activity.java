package com.ecommerce.hashtagcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {

    EditText email, password , signIn;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        email = (EditText) findViewById(R.id.etEmailLogin);
        password = (EditText) findViewById(R.id.etPasswordLogin);
        signIn = (EditText) findViewById(R.id.etSignIn);
        login = (Button) findViewById(R.id.btnLogin);
    }


}