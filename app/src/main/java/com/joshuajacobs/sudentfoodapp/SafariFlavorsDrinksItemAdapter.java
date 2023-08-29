package com.joshuajacobs.sudentfoodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class SafariFlavorsDrinksItemAdapter extends RecyclerView.Adapter<SafariFlavorsDrinksItemAdapter.DrinksItemViewHolder> {

    private List<SafariFlavorsDrinksItem> drinksItemList;

    public SafariFlavorsDrinksItemAdapter(List<SafariFlavorsDrinksItem> drinksItemList) {
        this.drinksItemList = drinksItemList;
    }

    @NonNull
    @Override
    public DrinksItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsfadeeldrinkslayout, parent, false);
        return new DrinksItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksItemViewHolder holder, int position) {
        SafariFlavorsDrinksItem drinksItem = drinksItemList.get(position);
        holder.textViewName.setText(drinksItem.getItemName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "$%.2f", drinksItem.getItemPrice()));
    }

    @Override
    public int getItemCount() {
        return drinksItemList.size();
    }

    public static class DrinksItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewPrice;

        public DrinksItemViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
