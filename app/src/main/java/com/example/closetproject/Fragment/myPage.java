package com.example.closetproject.Fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.closetproject.Adapter.myPageCA;
import com.example.closetproject.DTO.myPageVO;
import com.example.closetproject.R;

import java.util.ArrayList;
import java.util.Timer;
import android.content.Context;
import android.util.AttributeSet;


public class myPage extends Fragment {

    ViewPager viewPager;
    ImageView basket_main;
    View view9, view10, view11;
    GridView my_grid;
    ArrayList<myPageVO> data;
    myPageCA adapter;
    String[] s_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getLayoutInflater().inflate((R.layout.fragment_my_page), null);

        // 페이지 이동
        view9 = view.findViewById(R.id.view9);
        view10 = view.findViewById(R.id.view10);
        view11 = view.findViewById(R.id.view11);

        view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (Intent) new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.orderHistory"));
                startActivity(intent);
            }
        });

        view10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (Intent) new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.basketPage"));
                startActivity(intent);
            }
        });

        view11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (Intent) new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.AnalysisActivity"));
                startActivity(intent);
            }
        });

        // grid 화면 적용
        my_grid = view.findViewById(R.id.my_grid);
        data = new ArrayList<myPageVO>();


        for (int i = 0; i<s_name.length; i++){
            data.add(new myPageVO(p_name[i], img[i], "20,000원"));
        }

        adapter = new myPageCA(getActivity(), R.layout.fragment_my_list,data);

        my_grid.setAdapter(adapter);

        return view;
    }

}