package com.lambton.day1_sample;

import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.activity_main);

        enterUserName = findViewById(R.id.enterUserName);
        enterPass = findViewById(R.id.enterPassword);
        btnClickMe = findViewById(R.id.btnClickMe);
        setLabel = findViewById(R.id.dynamicText);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();

                String userName = enterUserName.getText().toString();
                String password = enterPass.getText().toString();

                if (userName.equals("admin@123") && password.equals("s3cr3t"))
                {
                    System.out.println("If");
                    Log.d("NAME", password);

                    setLabel.setText("Login Successfull");
                    setLabel.setTextColor(getResources().getColor(R.color.Green));

                }else {
                    System.out.println("Else");
                    setLabel.setText("Login Failed");
                    setLabel.setTextColor(getResources().getColor(R.color.Red));
                }

            }
        });
    }
}
