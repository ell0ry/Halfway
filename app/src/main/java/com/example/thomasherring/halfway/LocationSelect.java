package com.example.thomasherring.halfway;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thomasherring.halfway.MeetingObjects.Meeting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.gson.Gson;


import static android.content.Context.LOCATION_SERVICE;
import static android.location.Criteria.ACCURACY_FINE;
import static android.location.LocationManager.GPS_PROVIDER;
import static android.location.LocationManager.NETWORK_PROVIDER;
import static android.location.LocationManager.PASSIVE_PROVIDER;

public class LocationSelect extends AppCompatActivity {

    private final int PLACE_PICKER_REQUEST = 61;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {

            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

            startActivityForResult(builder.build(getApplicationContext()), PLACE_PICKER_REQUEST);


        } catch(GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException e){
            e.printStackTrace();
        }



        //setContentView(R.layout.activity_location_select);
    }

    public static Location getLatestLocation(final Context context) {
        LocationManager manager = (LocationManager) context
                .getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(ACCURACY_FINE);
        String provider = manager.getBestProvider(criteria, true);
        Location bestLocation;
        if (provider != null)
            bestLocation = manager.getLastKnownLocation(provider);
        else
            bestLocation = null;
        Location latestLocation = getLatest(bestLocation,
                manager.getLastKnownLocation(GPS_PROVIDER));
        latestLocation = getLatest(latestLocation,
                manager.getLastKnownLocation(NETWORK_PROVIDER));
        latestLocation = getLatest(latestLocation,
                manager.getLastKnownLocation(PASSIVE_PROVIDER));
        return latestLocation;


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {


            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
              //  String toastMsg = String.format("Place: %s", place.getName());
              //  Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
                Log.d("Location Select", "Received ok result");

                Gson gson = new Gson();

                //Serialize using the Gson library
                String json = gson.toJson(place.getLatLng());
                Intent intent = new Intent(this, FilterSelect.class);
                intent.putExtra("Loc", json);
                startActivity(intent);
            } else {
                finish();
            }
        }
    }


    /**
     * Looks at the two locations and determines which one is more recent
     * @param location1 -
     * @param location2
     * @return - the more recent location
     */
    private static Location getLatest(final Location location1,
                                      final Location location2) {
        if (location1 == null)
            return location2;

        if (location2 == null)
            return location1;

        if (location2.getTime() > location1.getTime())
            return location2;
        else
            return location1;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
