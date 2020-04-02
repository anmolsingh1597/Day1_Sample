package com.lambton.day1_sample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private ImageView homeImage;
    private Switch homeSwitch;
    private TextView welcomeText;
    //-----------------------Spinner-----------------------
    private Spinner countrySpinner;
    private String[] countryList;
    ArrayAdapter<String>countryAdapter;
    //-----------------------Auto Complete Text View-----------------------
    private AutoCompleteTextView autoCompleteValues;
    //-----------------------Auto Complete Text View-----------------------
    public static int REQUEST_COUNTRY_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeImage = findViewById(R.id.homeViewImage);
        homeSwitch = findViewById(R.id.homeSwitch);
        welcomeText = findViewById(R.id.homeTextView);
        countrySpinner = findViewById(R.id.homeCountrySpinner);
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

        //-----------------------Spinner-----------------------
        countryList = new String[]{
                "Canada", "India","USA","England"
        };
//        Get values from resources
//        countryList = getResources().getStringArray(R.array.designatedArray);
        countryAdapter = new ArrayAdapter<>(HomeActivity.this,
                android.R.layout.simple_spinner_item,
                countryList);
        countrySpinner.setAdapter(countryAdapter);
//        countrySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {             // it can be used on spinner
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(HomeActivity.this, countryList[position], Toast.LENGTH_SHORT).show();
//            }
//        });
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this,countryList[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //-----------------------Spinner-----------------------

        //-----------------------Auto Complete Text View-----------------------
        autoCompleteValues = findViewById(R.id.homeAutoCompleteDesignation);
        //        autoCompleteValues.setThreshold(3); // Start searching from 3 characters
        autoCompleteValues.setAdapter(countryAdapter);
        //-----------------------Auto Complete Text View-----------------------

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
                Intent countryIntent = new Intent(HomeActivity.this, UserActivity.class);
                startActivityForResult(countryIntent, REQUEST_COUNTRY_CODE);
                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_COUNTRY_CODE){
                String fetchedCountryName = data.getStringExtra("countryName");
                Toast.makeText(HomeActivity.this, fetchedCountryName, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
