package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VendorProfile extends AppCompatActivity {
    ListView simpleList;
    String countryList[] = {"Account Details", "Reviews", "Notifications","Transaction History"};
    ListView simpleList2;
    String countryList2[] = {"Settings", "About Us", "Help", "Log Out"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_profile);
        simpleList = (ListView)findViewById(R.id.listViewProfile);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_vendor_list_view, R.id.textView, countryList);
        simpleList.setAdapter(arrayAdapter);
        simpleList2 = (ListView)findViewById(R.id.listViewProfile2);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.activity_vendor_listview_2, R.id.textView2, countryList2);
        simpleList2.setAdapter(arrayAdapter2);



        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_profile: return true;
                case R.id.bottom_menuUpload:
                    startActivity(new Intent(getApplicationContext(),VendorMenu.class));
                    finish();
                    return true;


            }
            switch (item.getItemId()){
                case R.id.bottom_profile: return true;
                case R.id.bottom_specials:
                    startActivity(new Intent(getApplicationContext(),Specials.class));
                    finish();
                    return true;

            }



            switch (item.getItemId()){
                case R.id.bottom_profile: return true;
                case R.id.bottom_orders:
                    startActivity(new Intent(getApplicationContext(),VendorOrderStatus.class));
                    finish();
                    return true;

            }

            return false;
        });
    }
}