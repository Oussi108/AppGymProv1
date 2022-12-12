package com.systemx.gymapppro;


import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.ProgressBar;



public class Loadingscreen extends AppCompatActivity {

    ProgressBar pr ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingscreen);
        pr = findViewById(R.id.progressBar);
        getSupportActionBar().hide();
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Loadingscreen.this,MainActivity.class));
                finish();
            }
        }, 3500);
    }

    }
