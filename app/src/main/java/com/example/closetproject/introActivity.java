package com.example.closetproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class introActivity extends AnalysisActivity {
    private Animation alphaAni;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

    protected void onPause() {

        super.onPause();
        finish();
    }
}
