package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ClientProfileActivity extends AppCompatActivity {

    TextView txtUsername, txtPassword;
    Button logoutBtn, settingsBtn, accountDeletionBtn, personalDetailsBtn;
    ImageView homeImageView;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "LoginAccount";
    private static final String ACCOUNT_USERNAME = "Username";
    private static final String ACCOUNT_PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_profile);

        txtUsername = findViewById(R.id.accountNameDisplay);

        //Shared Preference Code
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String accountUsername = sharedPreferences.getString(ACCOUNT_USERNAME, null);
        String stringPassword = sharedPreferences.getString(ACCOUNT_PASSWORD, null);
        txtUsername.setText(accountUsername);

        //LogOut Button:
        logoutBtn = findViewById(R.id.profileLogoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clears Share Preference:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();

                //Go Back to Landing Page:
                Toast.makeText(ClientProfileActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ClientProfileActivity.this, LandingPage.class));
            }
        });

        //Home Button Image View:
        homeImageView = findViewById(R.id.homeImageView);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(ClientProfileActivity.this, ClientHomePageActivity.class));
            }
        });

        //Settings Button:
        settingsBtn = findViewById(R.id.settingBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClientProfileActivity.this, SettingsActivity.class));
            }
        });

        //Account Deletion:
        accountDeletionBtn = findViewById(R.id.accountDeletionBtn);
        accountDeletionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClientProfileActivity.this , ClientAccountDeletionActivity.class));
            }
        });

        //Personal Details:
        personalDetailsBtn = findViewById(R.id.personalDetailsBtn);

        personalDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ClientProfileActivity.this , ClientPersonalDetails.class));
            }
        });

    }//End of OnCreate
}
