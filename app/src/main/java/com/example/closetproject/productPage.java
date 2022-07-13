package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class productPage extends AppCompatActivity {

    ImageView s_basket3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        s_basket3 = findViewById(R.id.s_basket3);

        s_basket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(productPage.this, basketPage.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}