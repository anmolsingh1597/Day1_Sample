package com.lambton.day1_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    private TextView countryName;
    private Button saveCountryName;
    private TextView hiddenText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        saveCountry();
        fetchData();
    }

    public void saveCountry(){
        countryName = findViewById(R.id.countryNameField);
        saveCountryName = findViewById(R.id.countrySaveButton);
        hiddenText = findViewById(R.id.returnValueLabel);
    }

    public void countrySaveButton(View view){
      String enteredCountryName = countryName.getText().toString().trim();
        if (enteredCountryName.isEmpty()){
//            Toast.makeText(Country.this, "If", Toast.LENGTH_SHORT).show();
            countryName.setError("Enter Country Name");
        }else{
//            Toast.makeText(Country.this, "else", Toast.LENGTH_SHORT).show();
            Intent homeIntent = new Intent();
            homeIntent.putExtra("countryName", enteredCountryName);
            setResult(RESULT_OK, homeIntent);
            finish();
        }
    }
    public void userSaveButton(View view){
        String userName = countryName.getText().toString().trim();
        if (userName.isEmpty()){
//            Toast.makeText(Country.this, "If", Toast.LENGTH_SHORT).show();
            countryName.setError("Enter User Name");
        }else{
//            Toast.makeText(Country.this, "else", Toast.LENGTH_SHORT).show();
         Intent stringOperation = new Intent(UserActivity.this, StringOperationActivity.class);
         stringOperation.putExtra("userName", userName);
         startActivity(stringOperation);
         finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_new_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(),"Add",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_delete:
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_update:
                Toast.makeText(getApplicationContext(),"Update",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void fetchData(){
        Intent intent = getIntent();
        if (intent.hasExtra("alteredCase")) {
            String name = intent.getStringExtra("alteredCase");
            hiddenText.setText(name);
    }
    }
}
