package com.joshuajacobs.sudentfoodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SafariFlavorsSnacksItemAdapter extends RecyclerView.Adapter<SafariFlavorsSnacksItemAdapter.SnacksItemViewHolder> {

    private List<SafariFlavorsSnacksItem> snacksItemList;
    private Context context;

    public SafariFlavorsSnacksItemAdapter(List<SafariFlavorsSnacksItem> snacksItemList, Context context) {
        this.snacksItemList = snacksItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public SnacksItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_safarisnack_layout, parent, false);
        return new SnacksItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SnacksItemViewHolder holder, int position) {
        SafariFlavorsSnacksItem snacksItem = snacksItemList.get(position);
        holder.imageView.setImageResource(snacksItem.getItemImageResourceId());
        holder.textViewName.setText(snacksItem.getItemName());
        holder.textViewPrice.setText(String.format("$%.2f", snacksItem.getItemPrice()));
    }

    @Override
    public int getItemCount() {
        return snacksItemList.size();
    }

    public static class SnacksItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;

        public SnacksItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
