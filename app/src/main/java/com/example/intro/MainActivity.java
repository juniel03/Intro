package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String ALLOWED_CHARACTERS ="0123456789QWERTYUIOPASDFGHJKLZXCVBNM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 0 - 15 are available on my device
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int musicVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

        if (musicVolume == 0) {
            Toast.makeText(this, "Music is muted (getStreamVolume)", Toast.LENGTH_SHORT).show();
        }
    }

    public void random(View view) {
        Log.d("tag", getRandomString(6));
    }
    private static String getRandomString(final int sizeOfRandomString)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfRandomString);
        for(int i=0;i<sizeOfRandomString;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }
}