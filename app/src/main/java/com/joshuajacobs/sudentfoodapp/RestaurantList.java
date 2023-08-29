package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RestaurantList extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    public static List<String> data;
    DBHelperRestaurant db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        recyclerView
                = findViewById(R.id.my_recycler_view);

        db = new DBHelperRestaurant(this);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        data = new ArrayList<>();
        fetchData();
    }

    public void fetchData()
    {
        // Before fetching the data
        // directly from the database.
        // first we have to creates an empty
        // database on the system and
        // rewrites it with your own database.
        // Then we have to open the
        // database to fetch the data from it.
        db = new DBHelperRestaurant(this);
        try {
            db.createDataBase();
            db.openDataBase();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        data = db.getAlgorithmTopics(this);
        adapter = new RestaurantAdapter(this, data);
        recyclerView.setAdapter(adapter);

    }
}