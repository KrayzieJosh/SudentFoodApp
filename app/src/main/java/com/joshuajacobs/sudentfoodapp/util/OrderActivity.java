package com.joshuajacobs.sudentfoodapp.util;

//import android.support.v7.app.AppCompatActivity;
        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.widget.Toast;
        import androidx.appcompat.app.AppCompatActivity;
        import com.joshuajacobs.sudentfoodapp.R;
        import android.widget.ImageView;
        import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private ImageView imageViewFood;
    private TextView textViewFoodName;
    private TextView textViewDescription;
    private TextView textViewQuantity;
    private TextView textViewPrice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Find the views by their IDs
        imageViewFood = findViewById(R.id.imageViewFood);
        textViewFoodName = findViewById(R.id.textViewFoodName);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewQuantity = findViewById(R.id.textViewQuantity);
        textViewPrice = findViewById(R.id.textViewPrice);

        // Get the food details from the intent, this gets the food from the previous page
        String foodName = getIntent().getStringExtra("food_name");
        String description = getIntent().getStringExtra("description");
        int quantity = getIntent().getIntExtra("quantity", 0);
        double price = getIntent().getDoubleExtra("price", 0.0);
        int imageResId = getIntent().getIntExtra("image_res_id", 0);

        // Set the food details in the views
        imageViewFood.setImageResource(imageResId);
        textViewFoodName.setText(foodName);
        textViewDescription.setText(description);
        textViewQuantity.setText("Quantity: " + quantity);
        textViewPrice.setText("Price: $" + price);

        // Perform the order placement logic here
        // For example, you can send the order details to a server or process it locally

        // Show a success message
        Toast.makeText(this, "Order placed: " + foodName, Toast.LENGTH_SHORT).show();
    }
}
