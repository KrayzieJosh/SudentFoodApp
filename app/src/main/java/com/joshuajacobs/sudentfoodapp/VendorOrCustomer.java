package com.joshuajacobs.sudentfoodapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VendorOrCustomer extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.vendor_or_customer);

        Button vendorBtn=(Button)findViewById(R.id.signup_button);
       vendorBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(VendorOrCustomer.this,RegisterVendor.class));

           }
       });


   }
}
