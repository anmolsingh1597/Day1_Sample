package com.lambton.day1_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MaterialActivity extends AppCompatActivity {

    private SeekBar volumeSeekBar;
    private TextView seekText;
    private RatingBar userRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        intials();
    }
    private void intials(){
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        seekText = findViewById(R.id.seekBarText);
        userRating = findViewById(R.id.userRatingBar);
        seekBarAction();
        ratingBarAction();
    }

    // seek bar action
    private void seekBarAction(){
        volumeSeekBar.setProgress(20);
//        seekText.setText(String.valueOf(volumeSeekBar.getProgress()));
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekText.setText(String.valueOf(volumeSeekBar.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void ratingBarAction(){
        userRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                seekText.setText(String.valueOf(userRating.getProgress()));

            }
        });
    }
}
