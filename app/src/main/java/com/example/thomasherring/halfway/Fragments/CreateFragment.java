package com.example.thomasherring.halfway.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thomasherring.halfway.FriendSelect;
import com.example.thomasherring.halfway.LandingPage;
import com.example.thomasherring.halfway.R;

/**
 * Created by ThomasHerring on 2015-08-15.
 */
public class CreateFragment extends Fragment {


    public CreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create, container, false);
        final Button createReceipt = (Button) rootView.findViewById(R.id.createBtn);
        createReceipt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Replace with intent for launching
                Intent intent = new Intent(getActivity(), FriendSelect.class);
                startActivity(intent);
            }
        });

        return rootView;
    }



}

