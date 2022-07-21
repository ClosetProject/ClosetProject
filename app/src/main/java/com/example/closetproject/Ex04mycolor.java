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

public class Ex04mycolor extends Fragment {

    Button btn_b1, btn_b2, btn_b3, btn_b4;
    ColorDrawable color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ex04mycolor, container, false);

        btn_b1 = view.findViewById(R.id.btn_b1);
        btn_b2 = view.findViewById(R.id.btn_b2);
        btn_b3 = view.findViewById(R.id.btn_b3);
        btn_b4 = view.findViewById(R.id.btn_b4);

        btn_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_b1.setBackgroundColor(Color.parseColor("#5067AC"));
                    btn_b2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b4.setBackgroundColor(Color.parseColor("#686565"));
                }

            }
        });

        btn_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_b1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b2.setBackgroundColor(Color.parseColor("#2977BE"));
                    btn_b3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b4.setBackgroundColor(Color.parseColor("#686565"));
                }

            }
        });

        btn_b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_b1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b3.setBackgroundColor(Color.parseColor("#6C9CC6"));
                    btn_b4.setBackgroundColor(Color.parseColor("#686565"));
                }

            }
        });
        btn_b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_b1.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b4.setBackgroundColor(Color.parseColor("#69A5CD"));
                }

            }
        });
        return view;

    }
}