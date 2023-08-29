package com.joshuajacobs.sudentfoodapp;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private Button buttonRemoveItem;
    private Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        buttonRemoveItem = findViewById(R.id.buttonRemoveItem);
        placeOrderBtn = findViewById(R.id.placeOrder);
        buttonRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for removing an item
                removeItem();
            }
        });

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for placing order
                    startActivity(new Intent(OrderActivity.this, OrderActivity.class));
            }
        });
    }
    private void removeItem() {
        // Logic to remove an item from the order
        makeText(this, "Item removed from the order", Toast.LENGTH_SHORT).show();
    }

    private void placeOrder() {
        // Logic to proceed view order screen
        makeText(this, "Order placed", Toast.LENGTH_SHORT).show();
    }
}


