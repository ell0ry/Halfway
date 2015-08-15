package com.example.thomasherring.halfway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class FriendSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_select);

        final Button continueButton = (Button) findViewById(R.id.friendContinueBtn);
        continueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Replace with intent for launching
                Intent intent = new Intent(getApplicationContext(), LocationSelect.class);
                startActivity(intent);
            }


        });

        final Button cancelButton = (Button) findViewById(R.id.friendCancelBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Replace with intent for launching
                Intent intent = new Intent(getApplicationContext(), LandingPage.class);
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
