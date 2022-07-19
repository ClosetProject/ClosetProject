package com.example.closetproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.closetproject.Fragment.analysisPage;
import com.example.closetproject.Fragment.mainPage;
import com.example.closetproject.Fragment.myPage;
import com.example.closetproject.Fragment.storePage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    analysisPage fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프래그먼트를 여러개 사용 할 수 있게 만들어줌
        fragment = new analysisPage();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, fragment).commit();

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