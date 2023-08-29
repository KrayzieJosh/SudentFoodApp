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

public class FadeelsFoodItemRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<FadeelsFoodItem> foodItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadeelfood_layout);

        recyclerView = findViewById(R.id.recyclerViewFadeels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeFoodItems();

        FadeelsFoodItemAdapter adapter = new FadeelsFoodItemAdapter(foodItemList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderFadeelsButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FadeelsFoodItemRecycler.this, OrderActivity.class));
            }
        });
    }


    public void saveFoodItemToDatabase(FadeelsFoodItem foodItem) {
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
        foodItemList.add(new FadeelsFoodItem("Biryani", R.drawable.biryani_image, 10.0));
        foodItemList.add(new FadeelsFoodItem("Shawarma", R.drawable.shawarma_image, 8.0));
        foodItemList.add(new FadeelsFoodItem("Curry", R.drawable.curry_image, 12.0));
        foodItemList.add(new FadeelsFoodItem("Roti", R.drawable.roti_image, 1.5));
        foodItemList.add(new FadeelsFoodItem("Kebabs", R.drawable.kebabs_image, 6.0));
    }

    // ... other methods
}
