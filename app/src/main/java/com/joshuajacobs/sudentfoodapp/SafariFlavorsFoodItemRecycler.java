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

public class SafariFlavorsFoodItemRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<SafariFlavorsFoodItem> foodItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safarifood_layout);

        recyclerView = findViewById(R.id.recyclerViewSafari);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeFoodItems();

        SafariFlavorsFoodItemAdapter adapter = new SafariFlavorsFoodItemAdapter(foodItemList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderSafariButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(SafariFlavorsFoodItemRecycler.this, OrderActivity.class));
            }
        });
    }


    public void saveFoodItemToDatabase(SafariFlavorsFoodItem foodItem) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", foodItem.getItemName());
        values.put("price", foodItem.getItemPrice());

        long newRowId = db.insert("snacks", null, values); // Update table name accordingly
        if (newRowId != -1) {
            Toast.makeText(this, "Food item added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add food item to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeFoodItems() {
        foodItemList = new ArrayList<>();
        foodItemList.add(new SafariFlavorsFoodItem("Boerewors", R.drawable.boerewors_image, 8.0));
        foodItemList.add(new SafariFlavorsFoodItem("Fufu", R.drawable.fufu_image, 7.5));
        foodItemList.add(new SafariFlavorsFoodItem("Chakalaka", R.drawable.chakalaka_image, 6.0));
        foodItemList.add(new SafariFlavorsFoodItem("Pap", R.drawable.pap_image, 4.5));
        foodItemList.add(new SafariFlavorsFoodItem("Maize Meal", R.drawable.maize_meal_image, 5.0));
    }

    // ... other methods
}
