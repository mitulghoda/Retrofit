package com.databasedemo.Webservice.WebServices;



import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;


public class ApiHandler {

    private static final String BASE_URL = "https://api.teamsnap.com";






    private static final String BASE_api = "http://test.com/webservices/";



   // private static final String BASE_RECYCLEREFUEL = "http://192.168.1.102/recoverandrefuel/webservices/";




    private static final long HTTP_TIMEOUT = TimeUnit.SECONDS.toMillis(600);
    private static WebServices apiService;







    public static WebServices getApi() {
        if (apiService == null) {


            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setConnectTimeout(HTTP_TIMEOUT, TimeUnit.MILLISECONDS);
            okHttpClient.setWriteTimeout(HTTP_TIMEOUT, TimeUnit.MILLISECONDS);
            okHttpClient.setReadTimeout(HTTP_TIMEOUT, TimeUnit.MILLISECONDS);

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(BASE_api)
                    .setClient(new OkClient(okHttpClient))
                    .setConverter(new GsonConverter(new Gson()))
                    .build();

            apiService = restAdapter.create(WebServices.class);
            return apiService;
        } else {
            return apiService;
        }


    }
}
