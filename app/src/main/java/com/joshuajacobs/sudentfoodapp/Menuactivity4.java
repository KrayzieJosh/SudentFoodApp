package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menuactivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonSnacks = findViewById(R.id.snacksButton);
        Button buttonFood = findViewById(R.id.foodButton);
        Button buttonDrinks = findViewById(R.id.drinksButton);

        buttonFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity4.this, SafariFlavorsFoodItemRecycler.class);
                startActivity(intent);
            }
        });

        buttonDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity4.this, SafariFlavorsDrinksItemRecycler.class);
                startActivity(intent);
            }
        });

        buttonSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity4.this, SafariFlavorsSnacksItemRecycler.class);
                startActivity(intent);
            }
        });
    }
}
