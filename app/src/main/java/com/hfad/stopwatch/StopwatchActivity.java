package com.hfad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class StopwatchActivity extends Activity {

    private int seconds = 0; // Use the seconds to record the number of seconds
    private boolean running; // use the running to set whether the stopwatch is running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    // Start the stopwatch running when the Start button is clicked
    public void onClickStart(View view){
        running = true; //Start the stopwatch
    }

    // Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view){
        running = false; // Stop the stopwatch
    }

    // Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view){
        running = false; //Stop the stopwatch and
        seconds = 0; // set the seconds to 0
    }
}
