package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends Activity {

    private int seconds = 0; // Use the seconds to record the number of seconds
    private boolean running; // use the running to set whether the stopwatch is running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }

    // Start the stopwatch running when the Start button is clicked
    public void onClickStart(View view) {
        running = true; //Start the stopwatch
    }

    // Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view) {
        running = false; // Stop the stopwatch
    }

    // Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false; //Stop the stopwatch and
        seconds = 0; // set the seconds to 0
    }

    /*  This method get a reference to the text view;
        format the seconds and display the result in the text view
    */
    private void runTimer() {
        // Get the text view
        final TextView timeView = (TextView) findViewById(R.id.time_view);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Format the seconds into hours, minutes, and seconds
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++; // Increment seconds if running is true
                }
                handler.postDelayed(this, 1000); //always run this runnable again after 1,000 milliseconds.
            }
        });

    }
}