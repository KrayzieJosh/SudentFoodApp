package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VendorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_menu);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_menuUpload);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottom_menuUpload: return true;
                case R.id.bottom_specials:
                    startActivity(new Intent(getApplicationContext(),Specials.class));
                    finish();
                    return true;

            }
            switch (item.getItemId()){
                case R.id.bottom_menuUpload: return true;
                case R.id.bottom_orders:
                    startActivity(new Intent(getApplicationContext(),VendorOrderStatus.class));
                    finish();
                    return true;

            }
            switch (item.getItemId()){
                case R.id.bottom_menuUpload: return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(),VendorProfile.class));
                    finish();
                    return true;

            }

            return false;
        });
    }
}