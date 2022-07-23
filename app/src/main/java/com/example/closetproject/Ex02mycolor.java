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

public class Ex02mycolor extends Fragment {

    Button btn_y1, btn_y2, btn_y3, btn_y4;
    ConstraintLayout y_color1, y_color2, y_color3, y_color4;
    ColorDrawable color;
    private int[] arrColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex02mycolor, container, false);

        btn_y1 = view.findViewById(R.id.btn_y1);
        btn_y2 = view.findViewById(R.id.btn_y2);
        btn_y3 = view.findViewById(R.id.btn_y3);
        btn_y4 = view.findViewById(R.id.btn_y4);

        y_color1 = view.findViewById(R.id.y_color1);
        y_color2 = view.findViewById(R.id.y_color2);
        y_color3 = view.findViewById(R.id.y_color3);
        y_color4 = view.findViewById(R.id.y_color4);

        switch(GlobalVariate.getInstance().getD_season()){
            case "SW":
                arrColor = new int[]{R.color.spring_l_yellow1, R.color.spring_l_yellow2,
                                     R.color.spring_b_yellow1, R.color.spring_b_yellow2};
                break;
            case "SC":
                arrColor = new int[]{R.color.summer_m_yellow1, R.color.summer_m_yellow2,
                                     R.color.summer_l_yellow1, R.color.summer_l_yellow2};
                break;
            case "AW":
                arrColor = new int[]{R.color.autumn_m_yellow1, R.color.autumn_m_yellow2,
                                     R.color.autumn_d_yellow1, R.color.autumn_d_yellow2};
                break;
            case "WC":
                arrColor = new int[]{R.color.winter_b_yellow1, R.color.winter_b_yellow2,
                                     R.color.winter_d_yellow1, R.color.winter_d_yellow2};
                break;
        }

        y_color1.setBackgroundResource(arrColor[0]);
        y_color2.setBackgroundResource(arrColor[1]);
        y_color3.setBackgroundResource(arrColor[2]);
        y_color4.setBackgroundResource(arrColor[3]);

        btn_y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_y1.setBackgroundColor(Color.parseColor("#F6C827"));
                    btn_y2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(1,1);
                }

            }
        });

        btn_y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_y1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y2.setBackgroundColor(Color.parseColor("#FEF226"));
                    btn_y3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(1,2);
                }

            }
        });

        btn_y3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_y1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y3.setBackgroundColor(Color.parseColor("#FDD276"));
                    btn_y4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(1,3);
                }

            }
        });
        btn_y4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_y1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y4.setBackgroundColor(Color.parseColor("#FCF380"));
                    GlobalVariate.getInstance().addSelf_cnt(1,4);
                }
            }
        });
        return view;
    }

}