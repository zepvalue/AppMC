package com.example.zepvalue.appmc;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.youtube.player.YouTubeIntents;


public class UploadChallenge extends ActionBarActivity {

    private static final String EXTRA_LOCAL_ONLY = "android.intent.extra.LOCAL_ONLY";
    private static final int SELECT_VIDEO_REQUEST = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_challenge);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upload_challenge, menu);
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

    public void userProfile(View v)
    {
        Intent i = new Intent(this, userProfile.class);
        startActivity(i);

    }

    public void recordVideo(View v)
    {
        Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(i, SELECT_VIDEO_REQUEST);
    }


    public void uploadVideo(View v)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, null).setType("video/*");
        intent.putExtra(EXTRA_LOCAL_ONLY, true);
        startActivityForResult(intent, SELECT_VIDEO_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnedIntent) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case SELECT_VIDEO_REQUEST:
                    Intent intent = YouTubeIntents.createUploadIntent(this, returnedIntent.getData());
                    startActivity(intent);
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, returnedIntent);
    }

}

