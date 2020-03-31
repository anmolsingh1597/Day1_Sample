package com.lambton.day1_sample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText enterUserName;
    public EditText enterPass;
    private Button btnClickMe;
    private TextView setLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intials();

btnClickMe.setOnClickListener(this);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName = enterUserName.getText().toString();
                String password = enterPass.getText().toString();

                if (userName.equals("admin@123") && password.equals("s3cr3t"))
                {
                    Log.d("NAME", password);
                    Toast.makeText(LoginActivity.this,"Success!",Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(homeIntent);

                }else {

                    Toast.makeText(LoginActivity.this,"Failure!",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    // override method of View.onClickListner interface
    @Override
    public void onClick(View v) {
//        Toast.makeText(LoginActivity.this,"Done" + HomeActivity.class,Toast.LENGTH_SHORT).show();
//        Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class); // jump from login to home screen // HomeActivity.class = "com.lambton.day1_sample.HomeActivity"
//        startActivity(homeIntent);
//       // finish(); // this will popOut previous screen from stack
    }

    private void intials () {
        enterUserName = findViewById(R.id.loginUserName);
        enterPass = findViewById(R.id.loginPassword);
        btnClickMe = findViewById(R.id.loginButton);
        ActionBar loginBar = getSupportActionBar();
        loginBar.hide();
    }
}
