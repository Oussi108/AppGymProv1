package com.systemx.gymapppro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView Bmenu ;
    BodyFragment bf = new BodyFragment();
    MachineFragment mf = new MachineFragment();
    TrackerFragment tf = new TrackerFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmenu = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.fContainer,bf).commit();
        Bmenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.body_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fContainer,bf).commit();
                        return true;

                    case R.id.machine_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fContainer,mf).commit();
                        return true;

                    case R.id.tracker_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fContainer,tf).commit();
                        return true;


                }
                return false;
            }
        });


    }
}