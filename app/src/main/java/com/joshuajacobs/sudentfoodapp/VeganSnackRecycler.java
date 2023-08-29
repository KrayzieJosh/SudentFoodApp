package com.joshuajacobs.sudentfoodapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VeganSnackRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<VeganSnackActivity> veganSnackActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegansnack_recycler);

        recyclerView = findViewById(R.id.recyclerViewVeganSnacks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeVeganSnacks();

        VeganSnackAdapter adapter = new VeganSnackAdapter(veganSnackActivityList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderVeganButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(VeganSnackRecycler.this, OrderActivity.class));
            }
        });
    }

    // Replace this method with your actual database logic
    public void saveVeganToDatabase(VeganSnackActivity veganSnackActivity) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", veganSnackActivity.getSnackName()); // Updated method name
        values.put("price", veganSnackActivity.getSnackPrice()); // Updated method name

        long newRowId = db.insert("snacks", null, values); // Update table name accordingly
        if (newRowId != -1) {
            Toast.makeText(this, "Vegan snack added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add vegan snack to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeVeganSnacks() {
        veganSnackActivityList = new ArrayList<>();
        veganSnackActivityList.add(new VeganSnackActivity("Hummus and Veggies", R.drawable.hummus_veggies_image, 5.0));
        veganSnackActivityList.add(new VeganSnackActivity("Trail Mix", R.drawable.trail_mix_image, 4.5));
        veganSnackActivityList.add(new VeganSnackActivity("Fruit Salad", R.drawable.fruit_salad_image, 4.0));
        veganSnackActivityList.add(new VeganSnackActivity("Rice Cakes", R.drawable.rice_cakes_image, 3.0));
        veganSnackActivityList.add(new VeganSnackActivity("Oat Bars", R.drawable.oat_bars_image, 3.5));
        veganSnackActivityList.add(new VeganSnackActivity("Dark Chocolate", R.drawable.dark_chocolate_image, 3.0));
    }

    // ... other methods
}
