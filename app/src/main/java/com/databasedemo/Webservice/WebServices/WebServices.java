package com.databasedemo.Webservice.WebServices;





import com.databasedemo.APIModel.CoachPreferencesMain.CoachPreferencesMainResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.QueryMap;


public interface WebServices {








    //TODO   Coach preferences/////******************************************************************************************************

    @POST("/getAllFoods")
    public  void getCoachPreferences(@QueryMap Map<String, String> map,
                                     Callback<CoachPreferencesMainResponse> callback);



    @GET("/getSubCategorybyCategoryId")
    public void getsubcategoriesgrid(@QueryMap Map<String, String> map, Callback<CoachPreferencesMainResponse> callback);



}







