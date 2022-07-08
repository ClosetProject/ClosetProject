package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.closetproject.Adapter.basketCA;
import com.example.closetproject.DTO.basketVO;

import java.util.ArrayList;

public class basketPage extends AppCompatActivity {

    ListView basket_lv;
    ArrayList<basketVO> data;
    basketCA adapter;
    String[] s_name;
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_page);

        basket_lv = findViewById(R.id.basket_lv);
        data = new ArrayList<basketVO>();

        for (int i = 0; i < s_name.length; i++){
            data.add(new basketVO(s_name[i], p_name[i], "20,000원", "흰색/FREE", img[i]));
        }

        adapter = new basketCA(basketPage.this,R.layout.basket_list,data);

        basket_lv.setAdapter(adapter);

    }
}