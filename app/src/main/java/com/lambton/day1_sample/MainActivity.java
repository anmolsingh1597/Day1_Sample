package com.lambton.day1_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public EditText enterUserName;
    public EditText enterPass;
    private Button btnClickMe;
    private TextView setLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_simple_dark);
        getSupportActionBar().hide();

        enterUserName = findViewById(R.id.loginUserName);
        enterPass = findViewById(R.id.loginPassword);
        btnClickMe = findViewById(R.id.loginButton);


        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();

                String userName = enterUserName.getText().toString();
                String password = enterPass.getText().toString();

                if (userName.equals("admin@123") && password.equals("s3cr3t"))
                {
                    Log.d("NAME", password);
                    Toast.makeText(MainActivity.this,"Success!",Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(MainActivity.this,"Failure!",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
