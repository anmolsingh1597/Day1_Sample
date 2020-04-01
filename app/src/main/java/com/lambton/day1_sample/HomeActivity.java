package com.lambton.day1_sample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private ImageView homeImage;
    private Switch homeSwitch;
    private TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeImage = findViewById(R.id.homeViewImage);
        homeSwitch = findViewById(R.id.homeSwitch);
        welcomeText = findViewById(R.id.homeTextView);
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
        Intent intent = getIntent();
        if (intent.hasExtra("Name")) {
            String name = intent.getStringExtra("Name");
            int age = intent.getIntExtra("Age",0);
           welcomeText.setText("Welcome, " + name);
        }
    }
    public void homeAlertButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setIcon(R.drawable.logo_small_round);
        builder.setMessage("You got an Error!");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this,"Positive",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this,"Negative",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this,"Neutral",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }
}
