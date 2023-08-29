package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientAccountDeletionActivity extends AppCompatActivity {

    Boolean deleteAccount;
    Button proceedBtn, cancelBtn;
    DBHelperClient DB;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "LoginAccount";
    private static final String ACCOUNT_USERNAME = "Username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_account_deletion);

        //Shared Preference Code
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String accountUsername = sharedPreferences.getString(ACCOUNT_USERNAME, null);

        //Cancel Button:
        cancelBtn = findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClientAccountDeletionActivity.this, ClientHomePageActivity.class));
            }
        });


        //Proceed Button:
        proceedBtn = findViewById(R.id.proceedBtn);
        DB = new DBHelperClient(this);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Deleting the account via the DB:
                deleteAccount = DB.deleteClientByUsername(accountUsername);

                if (deleteAccount = true){

                    Toast.makeText(ClientAccountDeletionActivity.this, "Account Successfully Deleted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ClientAccountDeletionActivity.this , LandingPage.class));

                } else {

                    Toast.makeText(ClientAccountDeletionActivity.this, "Account Deletion Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
