package com.lambton.day1_sample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StringOperationActivity extends AppCompatActivity {

    private TextView labelText;
    public String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_operation);
        setLabel();
    }

    public void setLabel(){
        labelText = findViewById(R.id.stringOperationTitle);
        Intent intent = getIntent();
        if (intent.hasExtra("userName")) {
             name = intent.getStringExtra("userName");
            labelText.setText("Welcome, " + name);
        }
    }
    public void upperCaseButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setIcon(R.drawable.logo_small_round);
        builder.setMessage("Are you sure to send data back?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String alteredName = name.toUpperCase();
                Intent alteredCasedHome = new Intent(StringOperationActivity.this,UserActivity.class);
                alteredCasedHome.putExtra("alteredCase", alteredName);
                startActivity(alteredCasedHome);
                Toast.makeText(StringOperationActivity.this, alteredName, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();

    }
    public void lowerCaseButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setIcon(R.drawable.logo_small_round);
        builder.setMessage("Are you sure to send data back?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String alteredName = name.toLowerCase();
                Intent alteredCasedHome = new Intent(StringOperationActivity.this,UserActivity.class);
                alteredCasedHome.putExtra("alteredCase", alteredName);
                startActivity(alteredCasedHome);
                Toast.makeText(StringOperationActivity.this, alteredName, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();


    }
    public void noOfWordsButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setIcon(R.drawable.logo_small_round);
        builder.setMessage("Are you sure to send data back?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] alteredName = name.split("\\s+");
                int length = alteredName.length;
                Intent alteredCasedHome = new Intent(StringOperationActivity.this,UserActivity.class);
                alteredCasedHome.putExtra("alteredCase", String.valueOf(length));
                startActivity(alteredCasedHome);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();


    }
    public void lengthButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setIcon(R.drawable.logo_small_round);
        builder.setMessage("Are you sure to send data back?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int length = name.length();
                Intent alteredCasedHome = new Intent(StringOperationActivity.this,UserActivity.class);
                alteredCasedHome.putExtra("alteredCase", String.valueOf(length));
                startActivity(alteredCasedHome);
                dialog.dismiss();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();


    }

}
