package com.example.moves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Wellcom extends AppCompatActivity {
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcom);

        Intent i = new Intent(this,LoginAndSignup.class);

        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                //do what you need here after 1sec
                startActivity(i);
            }
        },3000);
    }

    }
