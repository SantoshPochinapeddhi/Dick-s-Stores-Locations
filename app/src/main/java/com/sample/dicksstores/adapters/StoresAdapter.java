package com.sample.dicksstores.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.sample.dicksstores.R;
import com.sample.dicksstores.activities.StoreDetailsActivity;
import com.sample.dicksstores.model.Venues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santosh on 12/22/17.
 */

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder> {

    public static final String STORE_DETAILS = "store_details";

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Venues venue = venues.get(position);
        if (venue != null) {
            final SharedPreferences prefObj = PreferenceManager.getDefaultSharedPreferences(context);
            holder.name.setText(venues.get(position).getName());
            if (venue.getLocation() != null) {
                holder.location.setText(venues.get(position).getLocation().getAddress());
                holder.city.setText(venues.get(position).getLocation().getCity() + " - " + venues.get(position).getLocation().getPostalCode());
                holder.state.setText(venues.get(position).getLocation().getState() + " " + venues.get(position).getLocation().getCountry());
            }

            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StoreDetailsActivity.class);
                    intent.putExtra(STORE_DETAILS, venues.get(position));
                    context.startActivity(intent);
                    ((AppCompatActivity) context).overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                }
            });

            holder.getLikeBtn().setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {
                    holder.likeBtn.setLiked(true);
                    SharedPreferences.Editor editor = prefObj.edit();
                    editor.putBoolean(venue.getId() + "", true).commit();
                }

                @Override
                public void unLiked(LikeButton likeButton) {
                    holder.likeBtn.setLiked(false);
                    SharedPreferences.Editor editor = prefObj.edit();
                    editor.putBoolean(venue.getId() + "", false).commit();
                }
            });

            holder.likeBtn.setLiked(prefObj.getBoolean(venue.getId() + "", false));

        }
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
        private TextView state;
        private LikeButton likeBtn;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            name = (TextView) itemView.findViewById(R.id.name_txt);
            location = (TextView) itemView.findViewById(R.id.location_txt);
            city = (TextView) itemView.findViewById(R.id.city_txt);
            state = (TextView) itemView.findViewById(R.id.state_txt);
            likeBtn = (LikeButton) itemView.findViewById(R.id.like_btn);
        }

        public View getView() {
            return view;
        }

        public LikeButton getLikeBtn() {
            return likeBtn;
        }
    }

    public StoresAdapter addAllItems(List<Venues> venues) {
        this.venues.addAll(venues);
        notifyDataSetChanged();
        return this;
    }

}
