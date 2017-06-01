package com.databasedemo.APIModel.CoachPreferencesMain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 07-02-2017.
 */
public class CoachPreferencesMainResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("foodArr")
    @Expose
    private FoodArrPreferences foodArr;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FoodArrPreferences getFoodArr() {
        return foodArr;
    }

    public void setFoodArr(FoodArrPreferences foodArr) {
        this.foodArr = foodArr;
    }
}
