package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientLoginActivity extends AppCompatActivity {

    //Attributes:
    EditText username, password;
    Button btnlogin;
    DBHelperClient DB;


    //Shared Preference Attributes:
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "LoginAccount";
    private static final String ACCOUNT_USERNAME = "Username";
    private static final String ACCOUNT_PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlogin);

        username = (EditText) findViewById(R.id.client_login_email);
        password = (EditText) findViewById(R.id.client_login_password);
        btnlogin = (Button) findViewById(R.id.client_login_button);
        DB = new DBHelperClient(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(ClientLoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{

                    //Checks users input in database
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);

                    if(checkuserpass==true){

                        //Shared Preference Code:
                        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString(ACCOUNT_USERNAME, username.getText().toString());
                        editor.putString(ACCOUNT_PASSWORD, password.getText().toString());
                        editor.apply();

                        //Toast Message and Directs to homepage
                        Toast.makeText(ClientLoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ClientLoginActivity.this , ClientHomePageActivity.class));


                    }else{
                        Toast.makeText(ClientLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    public void goToVendorLoginPage(View view) {
        Intent intent = new Intent(this, VendorLoginActivity.class);
        startActivity(intent);
    }
}
