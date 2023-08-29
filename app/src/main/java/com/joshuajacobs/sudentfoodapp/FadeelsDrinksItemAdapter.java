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

public class FadeelsDrinksItemAdapter extends RecyclerView.Adapter<FadeelsDrinksItemAdapter.DrinkItemViewHolder> {

    private List<FadeelsDrinkItem> drinkItemList;
    private FadeelsDrinksItemRecycler activity;

    public FadeelsDrinksItemAdapter(List<FadeelsDrinkItem> drinkItemList, FadeelsDrinksItemRecycler activity) {
        this.drinkItemList = drinkItemList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DrinkItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdrinklayout, parent, false);
        return new DrinkItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkItemViewHolder holder, int position) {
        FadeelsDrinkItem drinkItem = drinkItemList.get(position);
        holder.imageView.setImageResource(drinkItem.getItemImageResourceId());
        holder.textViewName.setText(drinkItem.getItemName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: $%.2f", drinkItem.getItemPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {
            // Call the appropriate method for saving to the database
            activity.saveDrinkItemToDatabase(drinkItem);
        });
    }

    @Override
    public int getItemCount() {
        return drinkItemList.size();
    }

    public static class DrinkItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public DrinkItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
