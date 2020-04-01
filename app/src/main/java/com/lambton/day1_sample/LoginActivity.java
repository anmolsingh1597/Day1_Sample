package com.lambton.day1_sample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText enterUserName;
    public EditText enterPass;
    private Button btnClickMe;
    private Switch rememberMe;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Logins");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intials();


        btnClickMe.setOnClickListener(this);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String userName = enterUserName.getText().toString();
                final String password = enterPass.getText().toString();

                if (userName.equals("admin@123") && password.equals("s3cr3t"))
                {
                    Log.d("NAME", password);
                    Toast.makeText(LoginActivity.this,"Success!",Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class);
                    homeIntent.putExtra("Name","Anmol");
                    homeIntent.putExtra("Age",23);
                    startActivity(homeIntent);
                    writeNewUser("user_1",userName,password);
                    rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked == true){
                                enterUserName.setText(userName);
                                enterPass.setText(password);
                            }
                        }
                    });
                }else {

                    loginAlert();

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
        rememberMe = findViewById(R.id.rememberMeSwitch);
        ActionBar loginBar = getSupportActionBar();
        loginBar.hide();

    }
    public void loginAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setIcon(R.drawable.logo_small_round);
        builder.setMessage("User ID Password Invalid");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"Positive",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"Negative",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"Neutral",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }

    // write data to Firebase
    public void writeNewUser(String userId, String userName, String password){

        LoginCredentials user = new LoginCredentials(userName,password);
        myRef.child("Users").child(userId).setValue(user);
    }
}
