package com.databasedemo.Retrofit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.databasedemo.APIModel.CoachPreferencesMain.CoachPreferencesMainResponse;
import com.databasedemo.APIModel.CoachPreferencesMain.DrinksArr;
import com.databasedemo.R;
import com.databasedemo.Webservice.WebServices.ApiHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by abc on 01-06-2017.
 */
public class ActivityApi extends AppCompatActivity {
    private String team_id="",list_coach="",from="";

    private ListView lv;



    PreferenceAdapterDrink preferenceAdapterDrink;


    List<DrinksArr> list_drink;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getSupportActionBar().hide();
        getData();
        idMappings();

        setListeners();


    }


    private void idMappings() {





        lv = (ListView)findViewById(R.id.lv);



        callCoachPreferencesApi();





    }

    private void setListAdapter() {





    }

    private void getData() {

        Intent intent = getIntent();
        Bundle extas = intent.getExtras();
        if(extas!= null){
            team_id=extas.getString("team_id");
            list_coach = extas.getString("list_coach");
            from= extas.getString("from");



        }


    }

    private void callCoachPreferencesApi() {

      
        
        ApiHandler.getApi().getCoachPreferences(getPreferencesMap(), new Callback<CoachPreferencesMainResponse>() {


            @Override
            public void success(CoachPreferencesMainResponse mainResponse, Response response) {
                


                if (mainResponse == null) {

                    Toast.makeText(ActivityApi.this, "Something went wrong...Please try again later.", Toast.LENGTH_SHORT).show();


                    return;
                }


                if (mainResponse.getStatus() == null) {

                    Toast.makeText(ActivityApi.this, "Something went wrong...Please try again later.", Toast.LENGTH_SHORT).show();


                    return;
                }
                if (mainResponse.getFoodArr() == null) {

                    Toast.makeText(ActivityApi.this, "No food  found for this...!!", Toast.LENGTH_SHORT).show();


                    return;
                }


                if (!mainResponse.getStatus().equals("success")) {

                    Toast.makeText(ActivityApi.this, "No food  found for this...!!", Toast.LENGTH_SHORT).show();


                    return;
                }


                if (mainResponse.getStatus().equals("success"))
                {



                    /////////TODO Drink//////////
                    if (mainResponse.getFoodArr().getDrinksArr() != null && !mainResponse.getFoodArr().getDrinksArr().isEmpty()) {




                        list_drink = mainResponse.getFoodArr().getDrinksArr();
                        Log.e("list_drink",""+list_drink.size());

                        Collections.sort(list_drink, new Comparator<DrinksArr>() {
                            public int compare(DrinksArr o1, DrinksArr o2) {
                                return o1.getFoodName().compareToIgnoreCase(o2.getFoodName());
                            }
                        });


                        preferenceAdapterDrink = new PreferenceAdapterDrink(ActivityApi.this, list_drink, ActivityApi.this,"coach");
                        lv.setAdapter(preferenceAdapterDrink);



                    }



//                    if (mainResponse.getFoodArr().getCarbohydratesArr() != null && !mainResponse.getFoodArr().getCarbohydratesArr().isEmpty()) {
//
//
//
//
//                        list_CarbohydratesArrs = mainResponse.getFoodArr().getCarbohydratesArr();
//
//                        Collections.sort(list_CarbohydratesArrs, new Comparator<CarbohydratesArr>() {
//                            public int compare(CarbohydratesArr o1, CarbohydratesArr o2) {
//                                return o1.getFoodName().compareToIgnoreCase(o2.getFoodName());
//                            }
//                        });
//
//
//                        preferenceAdapterCarboHydrates = new PreferenceAdapterCarboHydrates(ActivityApi.this, list_CarbohydratesArrs, ActivityApi.this,"coach");
//                        lv_carbo.setAdapter(preferenceAdapterCarboHydrates);
//
//
//
//                    }
//
//
//                    if (mainResponse.getFoodArr().getProteinsArr() != null && !mainResponse.getFoodArr().getProteinsArr().isEmpty()) {
//
//
//
//
//                        list_protiens = mainResponse.getFoodArr().getProteinsArr();
//
//                        Collections.sort(list_protiens, new Comparator<ProteinsArr>() {
//                            public int compare(ProteinsArr o1, ProteinsArr o2) {
//                                return o1.getFoodName().compareToIgnoreCase(o2.getFoodName());
//                            }
//                        });
//
//
//                        preferenceAdapterProtiens= new PreferenceAdapterProtiens(ActivityApi.this, list_protiens, ActivityApi.this,"coach");
//                        lv_pro.setAdapter(preferenceAdapterProtiens);
//
//
//
//                    }
//
//
//                    if (mainResponse.getFoodArr().getVegetablesArr() != null && !mainResponse.getFoodArr().getVegetablesArr().isEmpty()) {
//
//
//
//
//                        list_vegetables = mainResponse.getFoodArr().getVegetablesArr();
//
//                        Collections.sort(list_vegetables, new Comparator<VegetablesArr>() {
//                            public int compare(VegetablesArr o1, VegetablesArr o2) {
//                                return o1.getFoodName().compareToIgnoreCase(o2.getFoodName());
//                            }
//                        });
//
//
//                        preferenceAdapterVegetables = new PreferenceAdapterVegetables(ActivityApi.this, list_vegetables, ActivityApi.this,"coach");
//                        lv_veg.setAdapter(preferenceAdapterVegetables);
//
//
//
//                    }
//
//
//                    if (mainResponse.getFoodArr().getFruitsArr() != null && !mainResponse.getFoodArr().getFruitsArr().isEmpty()) {
//
//
//
//
//                        list_fruits = mainResponse.getFoodArr().getFruitsArr();
//
//                        Collections.sort(list_fruits, new Comparator<FruitsArr>() {
//                            public int compare(FruitsArr o1, FruitsArr o2) {
//                                return o1.getFoodName().compareToIgnoreCase(o2.getFoodName());
//                            }
//                        });
//
//
//                        preferenceAdapterFruits = new PreferenceAdapterFruits(ActivityApi.this, list_fruits, ActivityApi.this,"coach");
//                        lv_fruits.setAdapter(preferenceAdapterFruits);
//
//
//
//                    }
//
//
//                    if (mainResponse.getFoodArr().getFatsArr() != null && !mainResponse.getFoodArr().getFatsArr().isEmpty()) {
//
//
//
//
//                        list_fats= mainResponse.getFoodArr().getFatsArr();
//
//                        Collections.sort(list_fats, new Comparator<FatsArr>() {
//                            public int compare(FatsArr o1, FatsArr o2) {
//                                return o1.getFoodName().compareToIgnoreCase(o2.getFoodName());
//                            }
//                        });
//
//
//                        preferenceAdapterFats= new PreferenceAdapterFats(ActivityApi.this, list_fats, ActivityApi.this,"coach");
//                        lv_fat.setAdapter(preferenceAdapterFats);
//
//

   //                 }




                }


            }

            @Override
            public void failure(RetrofitError error) {

                error.printStackTrace();
                error.getMessage();
                Log.e("error", "" + error.getMessage());

            }
        });

    }
















    private void setListeners() {

    }







//    public void callSaveFoodApiCoach(int i,String id) {
//        FOOD_STATUS = i;
//        food_id = id;
//        if (!UIUtil.checkNetwork(ActivityApi.this)) {
//
//            UIUtil.showCustomDialog("Alert","There seems to be some problem with your internet connection. Please check.",ActivityApi.this);
//
//            return;
//        }
//
//        ApiHandler.getRecyclRefuelApi().setEatStatus(getsaveFoodMapCoach(), new Callback<COachSaveFoodMainResponse>() {
//
//
//            @Override
//            public void success(COachSaveFoodMainResponse mainResponse, Response response) {
//
//
//
//                if (mainResponse == null) {
//
//                    Toast.makeText(ActivityApi.this, "Something went wrong...Please try again later.", Toast.LENGTH_SHORT).show();
//
//
//                    return;
//                }
//
//
//                if (mainResponse.getStatus() == null) {
//
//                    Toast.makeText(ActivityApi.this, "Something went wrong...Please try again later.", Toast.LENGTH_SHORT).show();
//
//
//                    return;
//                }
//
//
//
//                if (!mainResponse.getStatus().equals("success")) {
//
//                    Toast.makeText(ActivityApi.this, "No food  found for this...!!", Toast.LENGTH_SHORT).show();
//
//
//                    return;
//                }
//
//
//                if (mainResponse.getStatus().equals("success")) {
//
//                    food_id = "";
//                }
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                food_id = "";
//                UIUtil.dismissDialog();
//                error.printStackTrace();
//                error.getMessage();
//                Log.e("error", "" + error.getMessage());
//
//            }
//        });
//
//    }



//    public void callSaveFoodApiPlayer(int i,String id) {
//        FOOD_STATUS = i;
//        food_id = id;
//        if (!UIUtil.checkNetwork(ActivityApi.this)) {
//
//            UIUtil.showCustomDialog("Alert","There seems to be some problem with your internet connection. Please check.",ActivityApi.this);
//
//            return;
//        }
//
//        ApiHandler.getRecyclRefuelApi().setEatStatusPlayer(getsaveFoodMapPlayer(), new Callback<COachSaveFoodMainResponse>() {
//
//
//            @Override
//            public void success(COachSaveFoodMainResponse mainResponse, Response response) {
//
//
//
//                if (mainResponse == null) {
//
//                    Toast.makeText(ActivityApi.this, "Something went wrong...Please try again later.", Toast.LENGTH_SHORT).show();
//
//
//                    return;
//                }
//
//
//                if (mainResponse.getStatus() == null) {
//
//                    Toast.makeText(ActivityApi.this, "Something went wrong...Please try again later.", Toast.LENGTH_SHORT).show();
//
//
//                    return;
//                }
//
//
//
//                if (!mainResponse.getStatus().equals("success")) {
//
//                    Toast.makeText(ActivityApi.this, "No food  found for this...!!", Toast.LENGTH_SHORT).show();
//
//
//                    return;
//                }
//
//
//                if (mainResponse.getStatus().equals("success")) {
//
//                    food_id = "";
//                }
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                food_id = "";
//                UIUtil.dismissDialog();
//                error.printStackTrace();
//                error.getMessage();
//                Log.e("error", "" + error.getMessage());
//
//            }
//        });
//
//    }

    private Map<String, String> getPreferencesMap() {
        Map<String, String> map = new HashMap<>();

        map.put("team_id", "2465578");
        map.put("coach_id", "10432770");


        Log.e("getMap", "" + map);

        return map;
    }

//    private Map<String, String> getPlayerPreferencesMap() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("id", ""+team_id);
//        map.put("id", ""+ UserDetail.user_id);
//
//
//        Log.e("getMap", "" + map);
//
//        return map;
//    }


//      private Map<String, String> getCoachSelectionMap() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("team_id", ""+team_id);
//        map.put("coach_id", ""+list_coach);
//        map.put("food_id", ""+food_id);
//        map.put("food_selection", ""+food_selection);
//        map.put("teamsnap_user_id", ""+food_user_id);
//
//        Log.e("getMap", "" + map);
//
//        return map;
//    }
//    private Map<String, String> getsaveFoodMapCoach() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("team_id", ""+team_id);
//        map.put("coach_id", ""+list_coach);
//        map.put("status", ""+FOOD_STATUS);
//        map.put("food_id", ""+food_id);
//        Log.e("getMap", "" + map);
//
//        return map;
//    }
//
//
//    private Map<String, String> getsaveFoodMapPlayer() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("team_id", ""+team_id);
//        map.put("teamsnap_user_id", ""+UserDetail.user_id);
//        map.put("status", ""+FOOD_STATUS);
//        map.put("food_id", ""+food_id);
//        Log.e("getMap", "" + map);
//
//        return map;
//    }
//    private Map<String, String> getFoodInfoMap() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("food_id", ""+food_id);
//
//
//        return map;
//    }
//
//
//    private Map<String, String> getaddFoodMap() {
//
//        String category_id= "";
//        if(category_posotion==1){
//            category_id="6";
//        }
//        else if(category_posotion==2){
//            category_id="2";
//        }
//        else if(category_posotion==3){
//            category_id="1";
//        }
//        else if(category_posotion==4){
//            category_id="4";
//        }
//        else if(category_posotion==5){
//            category_id="5";
//        }
//        else if(category_posotion==6){
//            category_id="3";
//        }
//
//        Map<String, String> map = new HashMap<>();
//
//        map.put("team_id", ""+team_id);
//        map.put("coach_id", ""+list_coach);
//        map.put("food_name", ""+txt_foodname.getText().toString());
//        map.put("food_category_id", ""+category_id);
//        Log.e("getMap", "" + map);
//
//        return map;
//    }
//
//    private Map<String, String> getaddFoodMapPlayer() {
//
//        String category_id= "";
//        if(category_posotion==1){
//            category_id="6";
//        }
//        else if(category_posotion==2){
//            category_id="2";
//        }
//        else if(category_posotion==3){
//            category_id="1";
//        }
//        else if(category_posotion==4){
//            category_id="4";
//        }
//        else if(category_posotion==5){
//            category_id="5";
//        }
//        else if(category_posotion==6){
//            category_id="3";
//        }
//
//        Map<String, String> map = new HashMap<>();
//
//        map.put("team_id", ""+team_id);
//        map.put("teamsnap_user_id", ""+UserDetail.user_id);
//        map.put("user_name", ""+UserDetail.first_name +" "+UserDetail.last_name );
//        map.put("food_name", ""+txt_foodname.getText().toString());
//        map.put("food_category_id", ""+category_id);
//
//        Log.e("getMap", "" + map);
//
//        return map;
//    }
//


}
