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

public class VeganFodRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<VeganItemActivity> veganItemActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veganfood_recycler);

        recyclerView = findViewById(R.id.recyclerViewVegan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeVeganItems();

        VeganAdapter adapter = new VeganAdapter(veganItemActivityList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderVeganButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(VeganFodRecycler.this, OrderActivity.class));
            }
        });
    }

    // Replace this method with your actual database logic
    public void saveVeganToDatabase(VeganItemActivity veganItemActivity) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", veganItemActivity.getVeganName());
        values.put("price", veganItemActivity.getVeganPrice());

        long newRowId = db.insert("snacks", null, values); // Update table name accordingly
        if (newRowId != -1) {
            Toast.makeText(this, "Vegan item added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add vegan item to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeVeganItems() {
        veganItemActivityList = new ArrayList<>();
        veganItemActivityList.add(new VeganItemActivity("Vegan Salad", R.drawable.vegan_salad_image, 8));
        veganItemActivityList.add(new VeganItemActivity("Falafel Plate", R.drawable.falafel_image, 9));
        veganItemActivityList.add(new VeganItemActivity("Sesame Noodles", R.drawable.sesame_noodles_image, 7));
        veganItemActivityList.add(new VeganItemActivity("Vegan Soup", R.drawable.vegan_soup_image, 6));
        veganItemActivityList.add(new VeganItemActivity("Fried Tofu", R.drawable.fried_tofu_image, 8));
        veganItemActivityList.add(new VeganItemActivity("Beyond Burger", R.drawable.beyond_burger_image, 10));
    }

    // ... other methods
}
