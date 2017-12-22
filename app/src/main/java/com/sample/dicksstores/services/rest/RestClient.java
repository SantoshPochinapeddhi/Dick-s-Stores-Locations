package com.sample.dicksstores.services.rest;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by santosh
 */
public class RestClient implements RequestInterceptor {

    private DicksService dService;

    public static final String BASE_URL = "https://movesync-qa.dcsg.com/dsglabs/mobile";

    public static final String TAG = RestClient.class.getSimpleName();

    public static RestClient getInstance() {
        return new RestClient();
    }


    /**
     * Creating rest adapter
     */
    public DicksService getDicksService() {
        final String dBaseUrl = BASE_URL;
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(dBaseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(this)
                .setClient(new retrofit.client.UrlConnectionClient())
                .build();
        dService = restAdapter.create(DicksService.class);
        return dService;
    }

    @Override
    public void intercept(RequestFacade request) {
        //
    }

}
