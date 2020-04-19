package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name= findViewById(R.id.etName);
        Password= findViewById(R.id.etPassword);
        Info= findViewById(R.id.tvinfo);
        Login= findViewById(R.id.btnLogin);
        Info.setText("No of attempts remaining: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void validate(String userName, String userPassword){
        if((userName.equals("Soumyadeep")) && (userPassword.equals("891079"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else
        {
            counter--;

            Info.setText("No of attempts remaining: " + counter);
            if(counter==0){
                Login.setEnabled(false);
            }
        }
        }
    }
