package com.ecommerce.hashtagcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("Root123"))
                    //correct
                    Toast.makeText(MainActivity.this,"Login sucessfully",Toast.LENGTH_LONG.show());
            }
        });


    }

}