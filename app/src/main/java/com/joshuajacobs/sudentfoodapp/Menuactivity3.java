package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menuactivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        Button foodButton = findViewById(R.id.foodButton);
        Button snacksButton = findViewById(R.id.snacksButton);
        Button drinksButton = findViewById(R.id.drinksButton);

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity3.this, FadeelsFoodItemRecycler.class);
                startActivity(intent);
            }
        });

        snacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity3.this, FadeelsSnacksItemRecycler.class);
                startActivity(intent);
            }
        });

        drinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menuactivity3.this, FadeelsDrinksItemRecycler.class);
                startActivity(intent);
            }
        });
    }
}
