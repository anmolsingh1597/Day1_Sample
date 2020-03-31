package com.lambton.day1_sample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private ImageView homeImage;
    private Switch homeSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeImage = findViewById(R.id.homeViewImage);
        homeSwitch = findViewById(R.id.homeSwitch);
        //homeSwitch.isChecked();// Get status of switch
        ActionBar homeBar = getSupportActionBar();
        homeBar.setTitle("Home");
        homeBar.setSubtitle("Home Screen");
        homeImage.setImageResource(R.drawable.ic_launcher_foreground); // set image dynamically
        homeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    Toast.makeText(HomeActivity.this,"On!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(HomeActivity.this,"Off!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
