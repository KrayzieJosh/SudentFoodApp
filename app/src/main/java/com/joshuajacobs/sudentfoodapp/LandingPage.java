package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        //Sign Up Button:
        Button signUp = findViewById(R.id.sign_up_btn);
        signUp.setOnClickListener(new View.OnClickListener() {

        Button sign = findViewById(R.id.sign_up_btn);
        Button sign2=findViewById(R.id.signInBtn);
        sign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this , VendorOrCustomerSignUp.class));
            }
        });

        //Sign In Button:
        Button signIn =  findViewById(R.id.signInBtn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this , ClientLoginActivity.class));
            }
        });



        sign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this,VendorOrCustomerLogin.class));
            }
        });

    }}
