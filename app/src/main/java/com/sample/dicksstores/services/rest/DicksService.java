package com.sample.dicksstores.services.rest;

import com.sample.dicksstores.model.Response;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by santosh
 */
public interface DicksService {

    @GET("/api/venue")
    void getStores(Callback<List<Response>> callBack);

}
