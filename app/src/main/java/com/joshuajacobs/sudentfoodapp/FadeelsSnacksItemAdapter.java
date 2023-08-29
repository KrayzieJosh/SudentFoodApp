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

public class FadeelsSnacksItemAdapter extends RecyclerView.Adapter<FadeelsSnacksItemAdapter.SnackItemViewHolder> {

    private List<FadeelsSnackItem> snackItemList;
    private FadeelsSnacksItemRecycler activity;

    public FadeelsSnacksItemAdapter(List<FadeelsSnackItem> snackItemList, FadeelsSnacksItemRecycler activity) {
        this.snackItemList = snackItemList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public SnackItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsnacklayout, parent, false);
        return new SnackItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SnackItemViewHolder holder, int position) {
        FadeelsSnackItem snackItem = snackItemList.get(position);
        holder.imageView.setImageResource(snackItem.getItemImageResourceId());
        holder.textViewName.setText(snackItem.getItemName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: $%.2f", snackItem.getItemPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {

            activity.saveSnackItemToDatabase(snackItem);
        });
    }

    @Override
    public int getItemCount() {
        return snackItemList.size();
    }

    public static class SnackItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public SnackItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
