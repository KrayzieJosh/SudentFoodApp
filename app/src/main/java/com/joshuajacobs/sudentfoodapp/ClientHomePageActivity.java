package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.joshuajacobs.sudentfoodapp.views.MenuActivity;

public class ClientHomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home_page);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_home: return true;
                case R.id.bottom_menuUpload:
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                    finish();
                    return true;

            }
            switch (item.getItemId()){
                case R.id.bottom_home: return true;
                case R.id.bottom_specials:
                   // startActivity(new Intent(getApplicationContext(),Specials.class));
                    //finish();
                    return true;

            }

            switch (item.getItemId()){
                case R.id.bottom_home: return true;
                //case R.id.bottom_orders:
                   // startActivity(new Intent(getApplicationContext(),VendorOrderStatus.class));
                    //finish();
                   // return true;

            }
            switch (item.getItemId()){
                case R.id.bottom_home: return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(),ClientProfileActivity.class));
                    finish();
                    return true;

            }

            return false;
        });

        //links for card views:
        //Payments View Card:
        CardView paymentsCard = findViewById(R.id.paymentCardView);

        paymentsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ClientHomePageActivity.this, "Payments", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ClientHomePageActivity.this, Payments.class);
                startActivity(intent);
            }
        });

        //Calender View Card:
        CardView calenderCard = findViewById(R.id.calenderCardView);

        calenderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ClientHomePageActivity.this, "Calender", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ClientHomePageActivity.this, Calendar.class);
                startActivity(intent);
            }
        });

        //Spin Wheel View Card:
        CardView spinWheelCard = findViewById(R.id.spinWheelCardView);

        spinWheelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ClientHomePageActivity.this, "Spin Wheel", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ClientHomePageActivity.this, SpinningWheel.class);
                startActivity(intent);
            }
        });
    }
}
