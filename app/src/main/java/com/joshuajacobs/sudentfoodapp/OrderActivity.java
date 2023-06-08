package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.joshuajacobs.sudentfoodapp.Payments;
import com.joshuajacobs.sudentfoodapp.R;

    public class OrderActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order);

            Button proceedToPay = findViewById(R.id.proceedPay);
            proceedToPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OrderActivity.this , Payments.class));
                }
                //fix emulator issue

            });
        }}


