package com.example.closetproject;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Ex02mycolor extends Fragment {

    Button btn_y1, btn_y2, btn_y3, btn_y4;
    ColorDrawable color;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex02mycolor, container, false);

        btn_y1 = view.findViewById(R.id.btn_y1);
        btn_y2 = view.findViewById(R.id.btn_y2);
        btn_y3 = view.findViewById(R.id.btn_y3);
        btn_y4 = view.findViewById(R.id.btn_y4);

        btn_y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_y1.setBackgroundColor(Color.parseColor("#F6C827"));
                    btn_y2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_y4.setBackgroundColor(Color.parseColor("#686565"));
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
                }

            }
        });
        return view;
    }
}