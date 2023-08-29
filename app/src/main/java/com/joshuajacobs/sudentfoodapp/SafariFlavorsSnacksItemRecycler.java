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

public class SafariFlavorsSnacksItemRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<SafariFlavorsSnacksItem> snacksItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safarisnack_layout);

        recyclerView = findViewById(R.id.recyclerViewSafari);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeSnacksItems();

        SafariFlavorsSnacksItemAdapter adapter = new SafariFlavorsSnacksItemAdapter(snacksItemList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderSafariButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SafariFlavorsSnacksItemRecycler.this, OrderActivity.class));
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
    private void initializeSnacksItems() {
        snacksItemList = new ArrayList<>();
        snacksItemList.add(new SafariFlavorsSnacksItem("Biltong", 5.0, R.drawable.biltong_image));
        snacksItemList.add(new SafariFlavorsSnacksItem("Lays", 2.5, R.drawable.chips_image));
        snacksItemList.add(new SafariFlavorsSnacksItem("Donuts", 3.0, R.drawable.donuts_image));
        snacksItemList.add(new SafariFlavorsSnacksItem("Nick Nacks", 1.5, R.drawable.nick_nacks_image));
        snacksItemList.add(new SafariFlavorsSnacksItem("Dark Chocolate", 4.0, R.drawable.dark_chocolate_image));
    }

    // ... other methods
}
