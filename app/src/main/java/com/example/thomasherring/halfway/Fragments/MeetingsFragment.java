package com.example.thomasherring.halfway.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.thomasherring.halfway.LandingPage;
import com.example.thomasherring.halfway.MeetingObjects.MeetingList;
import com.example.thomasherring.halfway.R;

import java.util.ArrayList;

/**
 * Created by ThomasHerring on 2015-08-15.
 */
public class MeetingsFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */


    public MeetingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meetings, container, false);
        ArrayList<String> meetings = new ArrayList<>();
        for(int i = 0; i < MeetingList.mainList.size();i++){
            meetings.add(String.valueOf(i));
        }
        ListAdapter adapter = new ArrayAdapter<String>(LandingPage.instance, android.R.layout.simple_list_item_1,meetings);
        ListView list = (ListView) LandingPage.instance.findViewById(R.id.listView);
        list.setAdapter(adapter);
        return rootView;

    }



}
