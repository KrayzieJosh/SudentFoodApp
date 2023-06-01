package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VendorOrCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_or_customer);

        Button vendorBtn=(Button)findViewById(R.id.signup_button);
        Button custBtn= (Button)findViewById((R.id.signup_buttonCustomer)) ;
        vendorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VendorOrCustomer.this,RegisterVendor.class));

            }
        });
        custBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VendorOrCustomer.this,ClientSignUpActivity.class));
            }
        });
    }
}