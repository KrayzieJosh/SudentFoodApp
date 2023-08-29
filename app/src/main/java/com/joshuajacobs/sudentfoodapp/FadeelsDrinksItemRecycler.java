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

public class FadeelsDrinksItemRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<FadeelsDrinkItem> drinkItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadeeldrink_layout);

        recyclerView = findViewById(R.id.recyclerViewFadeels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeDrinkItems();

        FadeelsDrinksItemAdapter adapter = new FadeelsDrinksItemAdapter(drinkItemList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderFadeelsButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(FadeelsDrinksItemRecycler.this, OrderActivity.class));
            }
        });
    }

    // Replace this with your actual database logic
    public void saveDrinkItemToDatabase(FadeelsDrinkItem drinkItem) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", drinkItem.getItemName());
        values.put("price", drinkItem.getItemPrice());

        long newRowId = db.insert("snacks", null, values); // Update table name accordingly
        if (newRowId != -1) {
            Toast.makeText(this, "Drink item added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add drink item to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeDrinkItems() {
        drinkItemList = new ArrayList<>();
        drinkItemList.add(new FadeelsDrinkItem("Coke", R.drawable.coke_image, 2.0));
        drinkItemList.add(new FadeelsDrinkItem("Water", R.drawable.water_image, 1.0));
        drinkItemList.add(new FadeelsDrinkItem("Falooda", R.drawable.falooda_image, 4.5));
        drinkItemList.add(new FadeelsDrinkItem("Tea", R.drawable.tea_image, 1.5));
        drinkItemList.add(new FadeelsDrinkItem("Milkshake", R.drawable.milkshake_image, 3.0));
        drinkItemList.add(new FadeelsDrinkItem("Coffee", R.drawable.coffee_image, 2.5));
        drinkItemList.add(new FadeelsDrinkItem("Pepsi", R.drawable.pepsi_image, 2.0));
    }

    // ... other methods
}
