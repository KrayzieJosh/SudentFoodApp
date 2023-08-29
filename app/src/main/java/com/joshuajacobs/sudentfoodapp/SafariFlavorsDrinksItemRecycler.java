package com.joshuajacobs.sudentfoodapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SafariFlavorsDrinksItemRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<SafariFlavorsDrinksItem> drinksItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safaridrink_layout);

        recyclerView = findViewById(R.id.recyclerViewSafari);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeDrinksItems();

        SafariFlavorsDrinksItemAdapter adapter = new SafariFlavorsDrinksItemAdapter(drinksItemList);
        recyclerView.setAdapter(adapter);
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

    private void initializeDrinksItems() {
        drinksItemList = new ArrayList<>();
        drinksItemList.add(new SafariFlavorsDrinksItem("Coke", 2.5));
        drinksItemList.add(new SafariFlavorsDrinksItem("Water", 1.0));
        drinksItemList.add(new SafariFlavorsDrinksItem("Milkshake", 3.0));
        drinksItemList.add(new SafariFlavorsDrinksItem("Coffee", 2.0));
        drinksItemList.add(new SafariFlavorsDrinksItem("Tea", 1.5));
        drinksItemList.add(new SafariFlavorsDrinksItem("Pepsi", 2.5));
    }
}
