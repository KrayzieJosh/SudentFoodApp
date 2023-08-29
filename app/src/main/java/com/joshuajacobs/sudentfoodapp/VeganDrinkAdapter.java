package com.joshuajacobs.sudentfoodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joshuajacobs.sudentfoodapp.VeganDrinkActivity;

import java.util.List;
import java.util.Locale;

public class VeganDrinkAdapter extends RecyclerView.Adapter<VeganDrinkAdapter.VeganDrinkViewHolder> {

    private List<VeganDrinkActivity> veganDrinkActivityList;
    private VeganDrinkRecycler activity; // Update the activity type

    public VeganDrinkAdapter(List<VeganDrinkActivity> veganDrinkActivityList, VeganDrinkRecycler activity) {
        this.veganDrinkActivityList = veganDrinkActivityList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VeganDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfoodlayout, parent, false);
        return new VeganDrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeganDrinkViewHolder holder, int position) {
        VeganDrinkActivity veganDrinkActivity = veganDrinkActivityList.get(position);
        holder.imageView.setImageResource(veganDrinkActivity.getDrinkImageResourceId());
        holder.textViewName.setText(veganDrinkActivity.getVDrinkName()); // Update the method name
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: R%.2f", veganDrinkActivity.getVDrinkPrice())); // Update the method name
        holder.buttonAddToBasket.setOnClickListener(v -> {
            // Call the appropriate method for saving to the database
            activity.saveVeganToDatabase(veganDrinkActivity);
        });
    }

    @Override
    public int getItemCount() {
        return veganDrinkActivityList.size();
    }

    public static class VeganDrinkViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public VeganDrinkViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}

