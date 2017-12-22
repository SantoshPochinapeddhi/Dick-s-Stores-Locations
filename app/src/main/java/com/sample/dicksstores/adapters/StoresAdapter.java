package com.sample.dicksstores.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.dicksstores.R;
import com.sample.dicksstores.activities.StoreDetailsActivity;
import com.sample.dicksstores.model.Venues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santosh on 12/22/17.
 */

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder> {

    private static final String STORE_DETAILS = "store_details";

    private List<Venues> venues = new ArrayList<>();

    private Context context;

    private LayoutInflater inflater;

    public StoresAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_stores, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(venues.get(position).getName());
        holder.location.setText(venues.get(position).getLocation().getAddress());

        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StoreDetailsActivity.class);
                intent.putExtra(STORE_DETAILS, venues.get(position));
                context.startActivity(intent);
                ((AppCompatActivity) context).overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    /**
     * View holder to hold views
     * using view holder pattern
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView location;
        private TextView name;
        private TextView city;
        private TextView pin;
        private TextView state;
        private TextView country;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            name = (TextView) itemView.findViewById(R.id.name_txt);
            location = (TextView) itemView.findViewById(R.id.location_txt);
            city = (TextView) itemView.findViewById(R.id.city_txt);
            pin = (TextView) itemView.findViewById(R.id.pin_txt);
            state = (TextView) itemView.findViewById(R.id.state_txt);
            country = (TextView) itemView.findViewById(R.id.country_txt);
        }

        public View getView() {
            return view;
        }
    }

    public StoresAdapter addAllItems(List<Venues> venues) {
        this.venues.addAll(venues);
        notifyDataSetChanged();
        return this;
    }

}
