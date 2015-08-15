package com.example.thomasherring.halfway.MeetingObjects;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Tate on 2015-08-15.
 */

public class Meeting {

    public Meeting(){

    }

   public int catNum = 1;
   private LatLng masterLoc;


    ArrayList<LatLng> locations;
    ArrayList<MeetingUser> users;

    double centroidSumX = 0;
    double centroidSumY = 0;

    public Meeting(MeetingUser master) {
        users = new ArrayList<>();
        users.add(0, master);
        locations = new ArrayList<>();
    }

     public void changeLatLng(LatLng newLoc){
         masterLoc = new LatLng(newLoc.latitude, newLoc.longitude);
     }

    public LatLng calculatePoint() {

        for (int i = 0; i < users.size(); i++) {
            centroidSumX += locations.get(i).latitude;
        }
        double centroidX = centroidSumX / users.size();

        for (int i = 0; i < users.size(); i++) {
            centroidSumY += locations.get(i).longitude;
        }
        double centroidY = centroidSumX / users.size();
        //Put centroidSumX and centroidSumY into a location tat

        LatLng l =  new LatLng(centroidX, centroidY);

        return l;
    }

}