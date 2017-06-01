package com.databasedemo.APIModel.CoachPreferencesMain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abc on 07-02-2017.
 */
public class FoodArrPreferences {
    @SerializedName("DrinksArr")
    @Expose
    private List<DrinksArr> drinksArr = null;



    public List<DrinksArr> getDrinksArr() {
        return drinksArr;
    }

    public void setDrinksArr(List<DrinksArr> drinksArr) {
        this.drinksArr = drinksArr;
    }



}
