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

    public EditText enterPass;
    private Button btnClickMe;
    private TextView setLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterPass = findViewById(R.id.enterPassword);
        btnClickMe = findViewById(R.id.btnClickMe);
        setLabel = findViewById(R.id.dynamicText);


        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();

                String name = enterPass.getText().toString();
                Log.d("NAME", name);

                setLabel.setText(name);



            }
        });
    }
}
