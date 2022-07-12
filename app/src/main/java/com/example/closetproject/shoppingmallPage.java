package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.closetproject.Adapter.shoppingmallCA;
import com.example.closetproject.DTO.shoppingmallVO;

import java.sql.Array;
import java.util.ArrayList;

public class shoppingmallPage extends AppCompatActivity {

    GridView sho_grid;
    ArrayList<shoppingmallVO> data;
    shoppingmallCA adapter;
    String[] s_name= {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingmall_page);

        sho_grid = findViewById(R.id.sho_grid);
        data = new ArrayList<shoppingmallVO>();

        for (int i = 0; i < s_name.length; i++){
            data.add(new shoppingmallVO("20,000원",s_name[i], p_name[i], img[i]));
        }

        adapter = new shoppingmallCA(shoppingmallPage.this, R.layout.shoppingmall_list,data);

        sho_grid.setAdapter(adapter);

    }
}