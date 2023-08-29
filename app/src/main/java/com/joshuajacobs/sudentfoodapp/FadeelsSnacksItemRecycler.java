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

public class FadeelsSnacksItemRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<FadeelsSnackItem> snackItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadeelsnack_layout);

        recyclerView = findViewById(R.id.recyclerViewFadeels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeSnackItems();

        FadeelsSnacksItemAdapter adapter = new FadeelsSnacksItemAdapter(snackItemList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderFadeelsButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(FadeelsSnacksItemRecycler.this, OrderActivity.class));
            }
        });
    }

    // Replace this with your actual database logic
    public void saveSnackItemToDatabase(FadeelsSnackItem snackItem) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", snackItem.getItemName());
        values.put("price", snackItem.getItemPrice());

        long newRowId = db.insert("snacks", null, values); // Update table name accordingly
        if (newRowId != -1) {
            Toast.makeText(this, "Snack item added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add snack item to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeSnackItems() {
        snackItemList = new ArrayList<>();
        snackItemList.add(new FadeelsSnackItem("Koeksisters", R.drawable.donuts_image, 1.5));
        snackItemList.add(new FadeelsSnackItem("Biltong", R.drawable.biltong_image, 2.0));
        snackItemList.add(new FadeelsSnackItem("Lays", R.drawable.chips_image, 1.0));
        snackItemList.add(new FadeelsSnackItem("5 Star", R.drawable.five_star_image, 0.5));
        snackItemList.add(new FadeelsSnackItem("Nick Nacks", R.drawable.nick_nacks_image, 1.2));
    }

    // ... other methods
}
