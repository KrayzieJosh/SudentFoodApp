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

import com.joshuajacobs.sudentfoodapp.OrderActivity;
import com.joshuajacobs.sudentfoodapp.VeganDrinkActivity;
import com.joshuajacobs.sudentfoodapp.menuDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class VeganDrinkRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<VeganDrinkActivity> veganDrinkActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegandrinks_layout);

        recyclerView = findViewById(R.id.recyclerViewVegan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeVeganDrinks();

        VeganDrinkAdapter adapter = new VeganDrinkAdapter(veganDrinkActivityList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.proceedToOrderVeganButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(VeganDrinkRecycler.this, OrderActivity.class));
            }
        });
    }

    // Replace this method with your actual database logic
    public void saveVeganToDatabase(VeganDrinkActivity veganDrinkActivity) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", veganDrinkActivity.getVDrinkName()); // Updated method name
        values.put("price", veganDrinkActivity.getVDrinkPrice()); // Updated method name

        long newRowId = db.insert("snacks", null, values); // Update table name accordingly
        if (newRowId != -1) {
            Toast.makeText(this, "Vegan drink added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add vegan drink to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeVeganDrinks() {
        veganDrinkActivityList = new ArrayList<>();
        veganDrinkActivityList.add(new VeganDrinkActivity("Water", R.drawable.water_image, 1.5));
        veganDrinkActivityList.add(new VeganDrinkActivity("Herbal Tea", R.drawable.herbal_tea_image, 2.0));
        veganDrinkActivityList.add(new VeganDrinkActivity("Green Tea", R.drawable.green_tea_image, 2.0));
        veganDrinkActivityList.add(new VeganDrinkActivity("Coffee", R.drawable.coffee_image, 2.5));
        veganDrinkActivityList.add(new VeganDrinkActivity("Fruit Juice", R.drawable.fruit_juice_image, 3.0));
        veganDrinkActivityList.add(new VeganDrinkActivity("Iced Coffee", R.drawable.iced_coffee_image, 3.5));
    }

    // ... other methods
}
