package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.closetproject.Adapter.orderCA;
import com.example.closetproject.DTO.orderVO;
import com.example.closetproject.Fragment.myPage;

import java.util.ArrayList;

public class orderHistory extends AppCompatActivity {

    ImageView next1;
    ListView order_lv;
    ArrayList<orderVO> data;
    orderCA adapter;
    String[] s_name = {"소녀나라", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"리턴 실키 셔츠 미니 원피스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        next1 = findViewById(R.id.next1);
        order_lv = findViewById(R.id.order_lv);
        data = new ArrayList<orderVO>();

        // 화면 전환
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(orderHistory.this, MainActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               finish();
            }
        });

        for (int i = 0; i < 1; i++){
            data.add(new orderVO("2022.07.25", "38,000원", s_name[i], p_name[i], "WHITE", "FREE", img[i]));
        }

        adapter = new orderCA(orderHistory.this,R.layout.order_list,data);

        order_lv.setAdapter(adapter);

    }
}