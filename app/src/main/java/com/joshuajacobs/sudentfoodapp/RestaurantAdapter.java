package com.joshuajacobs.sudentfoodapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter
        extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<String> data;
    Activity activity;

    public RestaurantAdapter(Activity activity,
                             List<String> data)
    {
        this.data = data;
        this.activity = activity;
    }

    // This method is used to attach
    // custom layout to the recycler view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType)
    {
        LayoutInflater LI
                = activity.getLayoutInflater();
        View vw = LI.inflate(
                R.layout.restaurant_list_layout, null);
        return new ViewHolder(vw);
    }

    // This method is used to set the action
    // to the widgets of our custom layout.
    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position)
    {
        String combinedValue = data.get(position);

        // Split the combined value into restaurantName and phoneNumber
        String[] parts = combinedValue.split(" ");
        String restaurantName = parts[0];
        String phoneNumber = parts[1];

        // Set the values to the appropriate views
        holder.topic_name.setText(restaurantName);
        holder.phNumber.setText(phoneNumber);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    class ViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView topic_name, phNumber;
        ImageView restaurantImage;
        public ViewHolder(View itemView)
        {
            super(itemView);
            // this.restaurantImage=itemView.findViewById(R.id.image);
            this.topic_name
                    = itemView.findViewById(R.id.textview);
            this.phNumber = itemView.findViewById(R.id.textemail);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {
                // Get the combined value from the data list
                String combinedValue = data.get(position);
                // Split the combined value to get restaurantName and phoneNumber

                // Create an Intent to start the DetailsActivity
                Intent intent = new Intent(activity, Menuactivity.class);
                activity.startActivity(intent);
            }
        }
    }}
