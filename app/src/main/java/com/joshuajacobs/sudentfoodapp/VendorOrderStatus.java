package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VendorOrderStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_order_status);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_orders);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_orders: return true;
                case R.id.bottom_menuUpload:
                    startActivity(new Intent(getApplicationContext(),VendorMenu.class));
                    finish();
                    return true;


            }
            switch (item.getItemId()){
                case R.id.bottom_orders: return true;
                case R.id.bottom_specials:
                    startActivity(new Intent(getApplicationContext(),Specials.class));
                    finish();
                    return true;

            }

            switch (item.getItemId()){
                case R.id.bottom_orders: return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(),VendorProfile.class));
                    finish();
                    return true;

            }

            return false;
        });
    }
}