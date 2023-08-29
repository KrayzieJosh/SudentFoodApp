package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menuactivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        Button foodButton = findViewById(R.id.foodButton);
        Button snacksButton = findViewById(R.id.snacksButton);
        Button drinksButton = findViewById(R.id.drinksButton);

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity2.this,VeganFodRecycler.class);
                startActivity(intent);
            }
        });

        snacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity2.this, VeganSnackRecycler.class);
                startActivity(intent);
            }
        });

        drinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity2.this,VeganDrinkRecycler.class);
                startActivity(intent);
            }
        });
    }
}
