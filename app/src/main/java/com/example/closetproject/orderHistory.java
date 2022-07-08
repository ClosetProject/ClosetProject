package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.closetproject.Adapter.orderCA;
import com.example.closetproject.DTO.orderVO;

import java.util.ArrayList;

public class orderHistory extends AppCompatActivity {

    ListView order_lv;
    ArrayList<orderVO> data;
    orderCA adapter;
    String[] s_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        order_lv = findViewById(R.id.order_lv);
        data = new ArrayList<orderVO>();

        for (int i = 0; i < s_name.length; i++){
            data.add(new orderVO("2022.07.07", "20,000원", s_name[i], p_name[i], "검정", "FREE", img[i]));
        }

        adapter = new orderCA(orderHistory.this,R.layout.order_list,data);

        order_lv.setAdapter(adapter);

    }
}