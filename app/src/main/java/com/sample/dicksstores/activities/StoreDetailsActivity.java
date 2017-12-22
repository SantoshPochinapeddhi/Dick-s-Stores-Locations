package com.sample.dicksstores.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sample.dicksstores.R;
import com.sample.dicksstores.adapters.StoresAdapter;
import com.sample.dicksstores.model.Venues;
import com.sample.dicksstores.util.UIDialog;

/**
 * Created by santosh on 12/22/17.
 */

public class StoreDetailsActivity extends AppCompatActivity {

    private ImageView img;

    private TextView location;

    private TextView name;

    private TextView city;

    private TextView state;

    private TextView link;

    private TextView phone;

    private TextView fb;

    private TextView twitter;

    private RatingBar rating;

    private TextView verified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);

        UIDialog.showUIDialog(this);

        getViews();

        Venues venue = getVenueFromIntent();


        if (venue.getName() != null) {
            name.setText(venue.getName());
        }

        if (venue.getLocation() != null) {
            location.setText(venue.getLocation().getAddress());
            city.setText(venue.getLocation().getCity() + " - " + venue.getLocation().getPostalCode());
            state.setText(venue.getLocation().getState() + " " + venue.getLocation().getCountry());
        }

        if (venue.getPhotos() != null && venue.getPhotos().length > 0 && !TextUtils.isEmpty(venue.getPhotos()[0].getUrl())) {
            Glide.with(this).load(venue.getPhotos()[0].getUrl()).into(img);
        }

        if (!TextUtils.isEmpty(venue.getUrl())) {
            link.setText(venue.getUrl());
        }

        if(!TextUtils.isEmpty(venue.getVerified())) {
            if(venue.getVerified().equalsIgnoreCase("true")) {
                verified.setText(R.string.verified);
            } else {
                verified.setText(R.string.not_verified);
            }
        }

        if(!TextUtils.isEmpty(venue.getRating())) {
            float val = Float.parseFloat(venue.getRating());
            rating.setRating(val);
            if(!TextUtils.isEmpty(venue.getRatingColor())) {
                String color = "#" + venue.getRatingColor();
                Drawable drawable = rating.getProgressDrawable();
                drawable.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
            }
        }

        if(venue.getContacts() != null && venue.getContacts().length > 0) {
            if(!TextUtils.isEmpty(venue.getContacts()[0].getPhone())) {
                phone.setText(venue.getContacts()[0].getPhone());
            }

            if(!TextUtils.isEmpty(venue.getContacts()[0].getFacebookName())) {
                fb.setText(venue.getContacts()[0].getFacebookName());
            }

            if(!TextUtils.isEmpty(venue.getContacts()[0].getTwitter())) {
                twitter.setText(venue.getContacts()[0].getTwitter());
            }
        }




        UIDialog.dismissDialog(this);
    }

    private Venues getVenueFromIntent() {
        Intent intent = getIntent();
        return (Venues) intent.getSerializableExtra(StoresAdapter.STORE_DETAILS);
    }

    private void getViews() {
        img = findViewById(R.id.img);
        name = findViewById(R.id.name_txt);
        location = findViewById(R.id.location_txt);
        city = findViewById(R.id.city_txt);
        state = findViewById(R.id.state_txt);
        link = findViewById(R.id.url);
        verified = findViewById(R.id.is_verified);
        phone = findViewById(R.id.number);
        twitter = findViewById(R.id.twitter);
        fb = findViewById(R.id.fb);
        rating = findViewById(R.id.rating);
    }
}
