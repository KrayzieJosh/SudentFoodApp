package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_signup);


        //button:
        Button myButton = findViewById(R.id.signup_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write the code that you want the button to execute when it is clicked.
                // For example:
                Toast.makeText(ClientSignUpActivity.this, "Signed Up!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void goToClientLoginPage(View view) {
        Intent intent = new Intent(this, ClientLoginActivity.class);
        startActivity(intent);
    }
}
