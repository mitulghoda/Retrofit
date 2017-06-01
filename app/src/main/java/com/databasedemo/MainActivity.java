package com.databasedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.databasedemo.Retrofit.ActivityApi;

import java.util.List;

public class MainActivity  extends Activity {

    TextView del,del_si,update_single;
    DatabaseHandler db ;
    TextView next_api;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idMapping();
        setClick();

        db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts



        List<Contact> contacts = db.getAllContacts();
        Log.e("si",""+contacts.size());
        if(contacts.size()==0){

            Log.e("size","0");
            db.addContact(new Contact("Ravi", "9100000000"));
        }
        else{
            Log.e("size",""+contacts.size());
            db.addContact(new Contact("eee", "9100000000"));
        }





        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);





        }





    }
    private void idMapping() {
        del = (TextView)findViewById(R.id.del);
        del_si = (TextView)findViewById(R.id.del_si);
        update_single = (TextView)findViewById(R.id.update_single);
        next_api = (TextView)findViewById(R.id.next_api);
    }
    private void setClick() {
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Reading: ", "Reading all contacts..");
                               List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.e("Name: ", log);




                }


                Log.e("si",""+contacts.size());
                db.delete();

            }
        });
        del_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.e("Name: ", log);


                    if(cn.getName().equalsIgnoreCase("Ravi")){


                       db.deleteContact(cn);


                        Log.e("record ","yes");



                    }
                    else{

                        Log.e("record ","not");
                        Log.e("record Data ",""+cn.getName());
                    }


                }




            }
        });

        update_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.e("Name: ", log);


                    if(cn.getName().equalsIgnoreCase("Ravi")){


                        cn.setName("s");
                        cn.setPhoneNumber("3");
                        db.updateContact(cn);


                        Log.e("record ","yes");



                    }
                    else{

                        Log.e("record ","not");
                        Log.e("record Data ",""+cn.getName());
                    }


                }



            }
        });
        next_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ActivityApi.class);
                startActivity(i);
            }
        });




    }
}
