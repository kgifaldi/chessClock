package com.example.leeam.myapplication;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.view.MotionEvent;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button startButton;
    Button pauseButton;
    ImageButton stopButton;
    Button resume;
    long time = 0;
    private Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.startButton);
        pauseButton = (Button)findViewById(R.id.pauseButton);
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        stopButton = (ImageButton) findViewById(R.id.iconButton);
        resume = (Button)findViewById(R.id.play);

    }

    public void onClick(View v){
        final MediaPlayer chesssound = MediaPlayer.create(this, R.raw.chessclick);
        switch(v.getId()){
            case R.id.startButton:
                chronometer.start();
                chronometer.setBase(SystemClock.elapsedRealtime());
                startButton.setBackgroundColor(Color.GRAY);
                pauseButton.setBackgroundColor(Color.CYAN);
                chronometer.setRotation(0);
                chesssound.start();
                break;

            case R.id.pauseButton:
                chronometer.start();
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseButton.setBackgroundColor(Color.GRAY);
                startButton.setBackgroundColor(Color.CYAN);
                chronometer.setRotation(180);
                chesssound.start();
                break;
            case R.id.iconButton:
                time = chronometer.getBase();
                chronometer.setBase(time);
                chronometer.stop();
                break;
            case R.id.play:
                time = chronometer.getBase();
                chronometer.setBase(time);
                chronometer.start();
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
