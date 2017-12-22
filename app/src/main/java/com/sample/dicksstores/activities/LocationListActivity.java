package com.sample.dicksstores.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sample.dicksstores.R;
import com.sample.dicksstores.adapters.StoresAdapter;
import com.sample.dicksstores.model.Response;
import com.sample.dicksstores.model.Venues;
import com.sample.dicksstores.services.rest.DicksService;
import com.sample.dicksstores.services.rest.RestClient;
import com.sample.dicksstores.util.NetworkUtil;
import com.sample.dicksstores.util.UIDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;

public class LocationListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        mRecyclerView = findViewById(R.id.recycler_view);

        if (NetworkUtil.isOnline(this)) {

            UIDialog.showUIDialog(this);
            DicksService service = RestClient.getInstance().getDicksService();
            service.getStores(new Callback<Response>() {
                @Override
                public void success(Response response, retrofit.client.Response response2) {
                    if (response != null && response.getVenues().length > 0) {
                        loadListWithStores(response.getVenues());
                    } else {
                        Toast.makeText(LocationListActivity.this, getString(R.string.unable_fetch_data), Toast.LENGTH_SHORT).show();
                        UIDialog.dismissDialog(LocationListActivity.this);
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    UIDialog.dismissDialog(LocationListActivity.this);
                    Toast.makeText(LocationListActivity.this, getString(R.string.unable_fetch_data), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void loadListWithStores(Venues[] venues) {
        List<Venues> venuesList = sortByFavs(new ArrayList<Venues>(Arrays.asList(venues)));
        StoresAdapter adapter = new StoresAdapter(LocationListActivity.this);
        adapter.addAllItems(venuesList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(LocationListActivity.this));
        UIDialog.dismissDialog(LocationListActivity.this);
    }

    private List<Venues> sortByFavs(List<Venues> venuesList) {
        SharedPreferences prefObj = PreferenceManager.getDefaultSharedPreferences(LocationListActivity.this);

        List<Integer> indexes = new ArrayList<>();
        for (Venues venue : venuesList) {
            boolean isFav = prefObj.getBoolean(venue.getId() + "", false);
            if (isFav) {
                indexes.add(venuesList.indexOf(venue));
            }
        }

        List<Venues> sortedList = new ArrayList<>();
        for(Integer i : indexes) {
            sortedList.add(venuesList.get(i));
        }
        for(Venues venue:venuesList) {
            if(!sortedList.contains(venue)) {
                sortedList.add(venue);
            }
        }

        return sortedList;
    }

}
