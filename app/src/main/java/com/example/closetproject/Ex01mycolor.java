package com.example.closetproject;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.closetproject.Retrofit_API.RetrofitInterface;

public class Ex01mycolor extends Fragment {

    Button btn_r1, btn_r2, btn_r3, btn_r4;
    ConstraintLayout r_color1, r_color2, r_color3, r_color4;
    ColorDrawable color;
    private RetrofitInterface retrofitAPI;
    private int[] arrColor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex01mycolor, container, false);

        btn_r1 = view.findViewById(R.id.btn_r1);
        btn_r2 = view.findViewById(R.id.btn_r2);
        btn_r3 = view.findViewById(R.id.btn_r3);
        btn_r4 = view.findViewById(R.id.btn_r4);

        r_color1 = view.findViewById(R.id.r_color1);
        r_color2 = view.findViewById(R.id.r_color2);
        r_color3 = view.findViewById(R.id.r_color3);
        r_color4 = view.findViewById(R.id.r_color4);

        switch(GlobalVariate.getInstance().getD_season()){
            case "SW":
                arrColor = new int[]{R.color.spring_l_red1, R.color.spring_l_red2,
                                     R.color.spring_b_red1, R.color.spring_b_red2};
                break;
            case "SC":
                arrColor = new int[]{R.color.summer_m_red1, R.color.summer_m_red2,
                                     R.color.summer_l_red1, R.color.summer_l_red2};
                break;
            case "AW":
                arrColor = new int[]{R.color.autumn_m_red1, R.color.autumn_m_red2,
                                     R.color.autumn_d_red1, R.color.autumn_d_red2};
                break;
            case "WC":
                arrColor = new int[]{R.color.winter_b_red1, R.color.winter_b_red2,
                                     R.color.winter_d_red1, R.color.winter_d_red2};
                break;
        }

        r_color1.setBackgroundResource(arrColor[0]);
        r_color2.setBackgroundResource(arrColor[1]);
        r_color3.setBackgroundResource(arrColor[2]);
        r_color4.setBackgroundResource(arrColor[3]);

        // if(d_result().equals("spring")){

        btn_r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_r1.setBackgroundColor(Color.parseColor("#F62B49"));
                    btn_r2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(0,1);
                }
            }
        });

        btn_r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_r1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r2.setBackgroundColor(Color.parseColor("#F34640"));
                    btn_r3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(0,2);
                }

            }
        });

        btn_r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_r1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r3.setBackgroundColor(Color.parseColor("#F9687E"));
                    btn_r4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(0,3);
                }
            }
        });

        btn_r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_r1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r4.setBackgroundColor(Color.parseColor("#FE6E74"));
                    GlobalVariate.getInstance().addSelf_cnt(0,4);
                }
            }
        });

        return view;
    }
}