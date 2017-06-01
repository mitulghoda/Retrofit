package com.databasedemo.APIModel.CoachPreferencesMain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 07-02-2017.
 */
public class DrinksArr {
    @SerializedName("food_category_id")
    @Expose
    private String foodCategoryId;
    @SerializedName("food_id")
    @Expose
    private String foodId;
    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("food_picture")
    @Expose
    private String foodPicture;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("is_player")
    @Expose
    private String is_player;

    public String getIs_player() {
        return is_player;
    }

    public void setIs_player(String is_player) {
        this.is_player = is_player;
    }

    public String getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(String foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(String foodPicture) {
        this.foodPicture = foodPicture;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
