package com.example.thomasherring.halfway;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thomasherring.halfway.MeetingObjects.Meeting;
import com.example.thomasherring.halfway.MeetingObjects.MeetingList;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FilterSelect extends AppCompatActivity {

    public static final String[] cat = {"Accounting", "Amusement Park", "Aquarium", "Art Gallery",
            "Bar", "Book Store", "Cafe", "Clothing Store", "Convenience Store", "Electronics Store",
            "Food", "Gym", "Hair Care", "Library", "Movie Theater", "Museum", "Night Club", "Park",
            "Shopping Mall"};

    public static final int[] catNum = {1, 3, 4, 5, 9, 12, 15, 25, 26, 32, 38, 44, 45, 55, 64, 66, 67, 69, 84};
    private String json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_select);

        Intent incoming = getIntent();
         json = incoming.getStringExtra("Loc");


        ArrayList<String> catAL = new ArrayList<String>();
        for (int i = 0; i < cat.length; ++i) {
            catAL.add(cat[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, catAL);

        ListView filterList = (ListView) findViewById(R.id.filterList);


        //Set listView for the updated arrayAdapter
        filterList.setAdapter(adapter);
        filterList.setTextFilterEnabled(true);
        filterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(parent.getContext(), LandingPage.class);
                Meeting toAdd = new Meeting();
                Gson gson = new Gson();
                LatLng masterLoc = masterLoc = gson.fromJson(json, LatLng.class);
                toAdd.changeLatLng(masterLoc);
                toAdd.catNum = catNum[position];
                MeetingList.mainList.add(toAdd);
                Toast.makeText(parent.getContext(), "Meeting added.", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }


           });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
