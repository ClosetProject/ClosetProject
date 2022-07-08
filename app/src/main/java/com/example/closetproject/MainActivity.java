package com.example.closetproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.closetproject.Fragment.analysisPage;
import com.example.closetproject.Fragment.mainPage;
import com.example.closetproject.Fragment.myPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnv);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, new mainPage()).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.tab1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, new mainPage()).commit();
                } else if (item.getItemId() == R.id.tab2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, new storePage()).commit();
                } else if (item.getItemId() == R.id.tab3) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, new analysisPage()).commit();
                } else if (item.getItemId() == R.id.tab4) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, new myPage()).commit();
                }
                return true;
            }
        });
    }
}