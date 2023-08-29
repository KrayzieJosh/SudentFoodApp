package com.joshuajacobs.sudentfoodapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.joshuajacobs.sudentfoodapp.views.OrderFragment;

public class CardFormActivity extends AppCompatActivity {

    private EditText cardNumberEditText;
    private EditText cardHolderEditText;
    private EditText expirationEditText;
    private EditText cvvEditText;
    private Button submitButton;
    private CheckBox checkBox;
    private DBHelperCard databaseHelper;

    private double accountBalance = 1000.0; // Initial account balance, you can set your own value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardform);

        cardNumberEditText = findViewById(R.id.cardNumberEditText);
        cardHolderEditText = findViewById(R.id.cardHolderEditText);
        expirationEditText = findViewById(R.id.expirationEditText);
        checkBox = findViewById(R.id.checkBox);
        cvvEditText = findViewById(R.id.cvvEditText);
        submitButton = findViewById(R.id.submitButton);

        databaseHelper = new DBHelperCard(this);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardNumber = cardNumberEditText.getText().toString();
                String cardHolder = cardHolderEditText.getText().toString();
                String expiration = expirationEditText.getText().toString();
                String cvv = cvvEditText.getText().toString();

                if (isValidInput(cardNumber, cardHolder, expiration, cvv)) {
                    boolean saveCardDetails = checkBox.isChecked();
                    if (saveCardDetails) {
                        if (databaseHelper.saveCardDetails(cardNumber, cardHolder, expiration, cvv)) {
                            Toast.makeText(CardFormActivity.this, "Card details saved successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CardFormActivity.this, "Failed to save card details", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    Toast.makeText(CardFormActivity.this, "Please enter valid card details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CardFormActivity.this , OrderFragment.class));
            }
        });
    }

    private boolean isValidInput(String cardNumber, String cardHolder, String expiration, String cvv) {
        // Add your validation logic here
        return !cardNumber.isEmpty() && !cardHolder.isEmpty() && !expiration.isEmpty() && !cvv.isEmpty();
    }

    private void performTransaction(double amount) {
        // Deduct the transaction amount from the account balance
        accountBalance -= amount;
        // Perform any necessary operations with the deducted amount (e.g., update backend, save to database, etc.)
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}

class DBHelperCard extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentFood.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "cards";
    private static final String COLUMN_CARD_NUMBER = "card_number";
    private static final String COLUMN_CARD_HOLDER = "card_holder";
    private static final String COLUMN_EXPIRATION = "expiration";
    private static final String COLUMN_CVV = "cvv";

    DBHelperCard(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_CARD_NUMBER + " TEXT, " +
                COLUMN_CARD_HOLDER + " TEXT, " +
                COLUMN_EXPIRATION + " TEXT, " +
                COLUMN_CVV + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    boolean saveCardDetails(String cardNumber, String cardHolder, String expiration, String cvv) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CARD_NUMBER, cardNumber);
        values.put(COLUMN_CARD_HOLDER, cardHolder);
        values.put(COLUMN_EXPIRATION, expiration);
        values.put(COLUMN_CVV, cvv);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }
}
