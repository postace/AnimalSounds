package com.postace.animalsounds;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // making noise when user touch the button
    public void makeNoise(View view) {

        // if some sound already created
        if (mplayer != null && mplayer.isPlaying()) {
            mplayer.stop();
        }

        int resId = view.getId();
        // get resource id
        String ourId = view.getResources().getResourceEntryName(resId);
        // finding resource from raw
        int animalSound = getResources().getIdentifier(ourId, "raw", getPackageName());
        // play sound
        mplayer = MediaPlayer.create(this, animalSound);
        mplayer.start();
    }
}
