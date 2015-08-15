package com.example.thomasherring.halfway.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomasherring.halfway.LandingPage;
import com.example.thomasherring.halfway.R;

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
        return rootView;
    }



}
