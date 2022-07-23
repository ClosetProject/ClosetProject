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

public class Ex03mycolor extends Fragment {

    Button btn_g1, btn_g2, btn_g3, btn_g4;
    ConstraintLayout g_color1, g_color2, g_color3, g_color4;
    ColorDrawable color;
    private int[] arrColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ex03mycolor, container, false);

        btn_g1 = view.findViewById(R.id.btn_g1);
        btn_g2 = view.findViewById(R.id.btn_g2);
        btn_g3 = view.findViewById(R.id.btn_g3);
        btn_g4 = view.findViewById(R.id.btn_g4);

        g_color1 = view.findViewById(R.id.g_color1);
        g_color2 = view.findViewById(R.id.g_color2);
        g_color3 = view.findViewById(R.id.g_color3);
        g_color4 = view.findViewById(R.id.g_color4);

        switch(GlobalVariate.getInstance().getD_season()){
            case "SW":
                arrColor = new int[]{R.color.spring_l_green1, R.color.spring_l_green2,
                        R.color.spring_b_green1, R.color.spring_b_green2};
                break;
            case "SC":
                arrColor = new int[]{R.color.summer_m_green1, R.color.summer_m_green2,
                        R.color.summer_l_green1, R.color.summer_l_green2};
                break;
            case "AW":
                arrColor = new int[]{R.color.autumn_m_green1, R.color.autumn_m_green2,
                        R.color.autumn_d_green1, R.color.autumn_d_green2};
                break;
            case "WC":
                arrColor = new int[]{R.color.winter_b_green1, R.color.winter_b_green2,
                        R.color.winter_d_green1, R.color.winter_d_green2};
                break;
        }

        g_color1.setBackgroundResource(arrColor[0]);
        g_color2.setBackgroundResource(arrColor[1]);
        g_color3.setBackgroundResource(arrColor[2]);
        g_color4.setBackgroundResource(arrColor[3]);

        btn_g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_g1.setBackgroundColor(Color.parseColor("#088D5D"));
                    btn_g2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(2,1);
                }
            }
        });
        btn_g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_g1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g2.setBackgroundColor(Color.parseColor("#2EA25B"));
                    btn_g3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(2,2);
                }
            }
        });
        btn_g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_g1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g3.setBackgroundColor(Color.parseColor("#82C785"));
                    btn_g4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(2,3);
                }
            }
        });
        btn_g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_g1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g4.setBackgroundColor(Color.parseColor("#97D568"));
                    GlobalVariate.getInstance().addSelf_cnt(2,4);
                }
            }
        });
        return view;
    }

    private void setSeasonColor(){
        switch(GlobalVariate.getInstance().getD_season()){
            case "WS":
                g_color1.setBackgroundResource(R.color.spring_l_green1);
                g_color2.setBackgroundResource(R.color.spring_l_green2);
                g_color3.setBackgroundResource(R.color.spring_b_green1);
                g_color4.setBackgroundResource(R.color.spring_b_green2);
                break;
            case "SC":
                g_color1.setBackgroundResource(R.color.summer_m_green1);
                g_color2.setBackgroundResource(R.color.summer_m_green2);
                g_color3.setBackgroundResource(R.color.summer_l_green1);
                g_color4.setBackgroundResource(R.color.summer_l_green2);
                break;
            case "AW":
                g_color1.setBackgroundResource(R.color.autumn_m_green1);
                g_color2.setBackgroundResource(R.color.autumn_m_green2);
                g_color3.setBackgroundResource(R.color.autumn_d_green1);
                g_color4.setBackgroundResource(R.color.autumn_d_green2);
                break;
            case "WC":
                g_color1.setBackgroundResource(R.color.winter_b_green1);
                g_color2.setBackgroundResource(R.color.winter_b_green2);
                g_color3.setBackgroundResource(R.color.winter_d_green1);
                g_color4.setBackgroundResource(R.color.winter_d_green2);
                break;
        }
    }
}