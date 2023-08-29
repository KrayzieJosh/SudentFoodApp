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

public class VeganAdapter extends RecyclerView.Adapter<VeganAdapter.VeganViewHolder> {

    private List<VeganItemActivity> veganItemActivityList;
    private VeganFodRecycler activity;

    public VeganAdapter(List<VeganItemActivity> veganItemActivityList, VeganFodRecycler activity) {
        this.veganItemActivityList = veganItemActivityList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VeganViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfoodlayout, parent, false);
        return new VeganViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeganViewHolder holder, int position) {
        VeganItemActivity veganItemActivity = veganItemActivityList.get(position);
        holder.imageView.setImageResource(veganItemActivity.getVeganImageResourceId());
        holder.textViewName.setText(veganItemActivity.getVeganName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: R%.2f", veganItemActivity.getVeganPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {
            // Call the appropriate method for saving to the database
            activity.saveVeganToDatabase(veganItemActivity);
        });
    }

    @Override
    public int getItemCount() {
        return veganItemActivityList.size();
    }

    public static class VeganViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public VeganViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
