package com.joshuajacobs.sudentfoodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class FadeelsFoodItemAdapter extends RecyclerView.Adapter<FadeelsFoodItemAdapter.FoodItemViewHolder> {

    private List<FadeelsFoodItem> foodItemList;
    private FadeelsFoodItemRecycler activity;

    public FadeelsFoodItemAdapter(List<FadeelsFoodItem> foodItemList, FadeelsFoodItemRecycler activity) {
        this.foodItemList = foodItemList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfoodlayout, parent, false);
        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        FadeelsFoodItem foodItem = foodItemList.get(position);
        holder.imageView.setImageResource(foodItem.getItemImageResourceId());
        holder.textViewName.setText(foodItem.getItemName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: $%.2f", foodItem.getItemPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {
            // Call the appropriate method for saving to the database
            activity.saveFoodItemToDatabase(foodItem);
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public static class FoodItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public FoodItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
