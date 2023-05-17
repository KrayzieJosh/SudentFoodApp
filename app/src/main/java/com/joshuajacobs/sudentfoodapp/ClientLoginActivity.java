package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientLoginActivity extends AppCompatActivity {

    private EditText mUsernameEditText, mPasswordEditText;
    private Button mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlogin);

        mUsernameEditText = findViewById(R.id.login_email);
        mPasswordEditText = findViewById(R.id.login_password);
        mLoginButton = findViewById(R.id.login_button);


        //button:
        Button myButton = findViewById(R.id.login_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //for database:
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                DatabaseHelper db = new DatabaseHelper(ClientLoginActivity.this);
                if (db.checkUser(username, password)) {
                    Toast.makeText(ClientLoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ClientLoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void goToClientSignUpPage(View view) {
        Intent intent = new Intent(this, ClientSignUpActivity.class);
        startActivity(intent);
    }
}
