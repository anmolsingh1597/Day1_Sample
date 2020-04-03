package com.lambton.day1_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {

    private TextView nameText;
    private Button saveButton;
    private SharedPreferences myPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        init();
    }
    private void init(){
        nameText = findViewById(R.id.sharedNameText);
        saveButton = findViewById(R.id.sharedSaveButton);
        myPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        save();
    }
    private void save(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                SharedPreferences.Editor nameEditor = myPref.edit();
                nameEditor.putString("keyName",name);
                nameEditor.apply();
//                nameEditor.commit();
//                nameEditor.clear();
//                nameEditor.remove("keyName");
                Intent move = new Intent(SharedPreferencesActivity.this,MaterialActivity.class);
                startActivity(move);

            }
        });
    }
}
