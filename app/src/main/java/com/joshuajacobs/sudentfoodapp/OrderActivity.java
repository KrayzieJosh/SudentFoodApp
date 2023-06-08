package com.joshuajacobs.sudentfoodapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private Button buttonRemoveItem;
    private Button buttonProceedToPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        buttonRemoveItem = findViewById(R.id.buttonRemoveItem);
        buttonProceedToPayments = findViewById(R.id.buttonProceedToPayments);

        buttonRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for removing an item
                removeItem();
            }
        });

        buttonProceedToPayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for proceeding to payments
                proceedToPayments();
            }
        });
    }

    private void removeItem() {
        // Logic to remove an item from the order
        Toast.makeText(this, "Item removed from the order", Toast.LENGTH_SHORT).show();
    }

    private void proceedToPayments() {
        // Logic to proceed to the payments screen
        Toast.makeText(this, "Proceeding to payments", Toast.LENGTH_SHORT).show();
    }
}


