package com.databasedemo.Retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.databasedemo.APIModel.CoachPreferencesMain.DrinksArr;
import com.databasedemo.R;
import com.databasedemo.application.ApiDemo;
import com.nostra13.universalimageloader.core.ImageLoader;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 16-12-2016.
 */
public class PreferenceAdapterDrink extends BaseAdapter {


    Context context;

    LayoutInflater inflater;


    private ImageLoader imageLoader;

    List<DrinksArr> data = new ArrayList<>();
    ActivityApi activity;
    String role="";
    public PreferenceAdapterDrink(Context context, List<DrinksArr> listview_food, ActivityApi activity, String role) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = listview_food;
        this.activity = activity;
        imageLoader = ImageLoader.getInstance();
        this.role= role;
    }

    @Override
    public int getCount() {
        return  data.size();
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }




    public class Holder
    {
        TextView txt_foodname;

        ImageView iv_food;
        TextView iv_player;
        ToggleButton toogle_food;
        LinearLayout ll_food_top;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        final Holder holder=new Holder();
        View rowView;

        if (convertView == null){

            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout, null);


        }

        holder.iv_food = (ImageView) convertView.findViewById(R.id.iv_food);
        holder.iv_player = (TextView) convertView.findViewById(R.id.iv_player);
        holder.ll_food_top = (LinearLayout) convertView.findViewById(R.id.ll_food_top);



        holder.txt_foodname = (TextView) convertView.findViewById(R.id.txt_foodname);

        if(data.get(position).getFoodName() !=null){
            holder.txt_foodname.setText(data.get(position).getFoodName());
        }
        imageLoader.displayImage(data.get(position).getFoodPicture(),holder.iv_food, ApiDemo.getFoodPicture(context));





        if(role.equals("coach"))
        {
            if(data.get(position).getIs_player().equals("0")){
                holder.iv_player.setVisibility(View.INVISIBLE);

            }
            else{


                holder.iv_player.setVisibility(View.VISIBLE);

            }

        }



//        if(data.get(position).getStatus()==0){
//            holder.toogle_food.setChecked(true);
//
//        }
//        else{
//
//            holder.toogle_food.setChecked(false);
//
//        }
//
//






//        holder.toogle_food.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if(data.get(position).getStatus()==0){
//
//                    data.get(position).setStatus(1);
//                    holder.toogle_food.setChecked(false);
//                    if(role.equals("coach"))
//                    {
//                        activity.callSaveFoodApiCoach(1,data.get(position).getFoodId());
//                    }
//                    else{
//                        activity.callSaveFoodApiPlayer(1,data.get(position).getFoodId());
//
//                    }
//
//                }
//                else{
//                    data.get(position).setStatus(0);
//                    holder.toogle_food.setChecked(true);
//
//                    if(role.equals("coach"))
//                    {
//                        activity.callSaveFoodApiCoach(0,data.get(position).getFoodId());
//                    }
//                    else{
//                        activity.callSaveFoodApiPlayer(0,data.get(position).getFoodId());
//
//                    }
//
//                }
//
//                notifyDataSetChanged();
//            }
//        });
//
//
//





        return convertView;
    }

}
