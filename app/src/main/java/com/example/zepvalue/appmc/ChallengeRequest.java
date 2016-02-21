package com.example.zepvalue.appmc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ChallengeRequest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge_request, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {

            Intent i = new Intent (this, userProfile.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void challengeRequest(View v)
    {
        Intent i = new Intent(this, ChallengeRequest.class);
        startActivity(i);
    }

    public void userProfile(View v)
    {
        Intent i = new Intent(this, userProfile.class);
        startActivity(i);
    }
}
