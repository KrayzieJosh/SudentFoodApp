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

public class VeganSnackAdapter extends RecyclerView.Adapter<VeganSnackAdapter.VeganSnackViewHolder> {

    private List<VeganSnackActivity> veganSnackActivityList;
    private VeganSnackRecycler activity;

    public VeganSnackAdapter(List<VeganSnackActivity> veganSnackActivityList, VeganSnackRecycler activity) {
        this.veganSnackActivityList = veganSnackActivityList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VeganSnackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfoodlayout, parent, false);
        return new VeganSnackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeganSnackViewHolder holder, int position) {
        VeganSnackActivity veganSnackActivity = veganSnackActivityList.get(position);
        holder.imageView.setImageResource(veganSnackActivity.getSnackImageResourceId());
        holder.textViewName.setText(veganSnackActivity.getSnackName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: R%.2f", veganSnackActivity.getSnackPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {
            // Call the appropriate method for saving to the database
            activity.saveVeganToDatabase(veganSnackActivity);
        });
    }

    @Override
    public int getItemCount() {
        return veganSnackActivityList.size();
    }

    public static class VeganSnackViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public VeganSnackViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
