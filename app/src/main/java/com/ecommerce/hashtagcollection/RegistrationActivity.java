package com.ecommerce.hashtagcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    Button signUp;
    EditText email,password;
    TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signUp = findViewById(R.id.btnSignup);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signIn = findViewById(R.id.tvSignIn);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,Login_Activity.class));
            }
        });
    }
}