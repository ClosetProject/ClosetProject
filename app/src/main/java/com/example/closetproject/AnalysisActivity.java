package com.example.closetproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class AnalysisActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> resultLauncher;
    private Button btn_runmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        btn_runmodel = findViewById(R.id.btn_runmodel);

        // intent 양방향 통신 리스너
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Intent 콜백 시, 동작할 함수
                    }
                });

        btn_runmodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // File System
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                // Chooser of filesystem optiona
                Intent chooserIntent = Intent.createChooser(intent,"select source");

                // Add the camera options
                resultLauncher.launch(Intent.createChooser(intent, "앱을 선택하세요"));
            }
        });
    }
}