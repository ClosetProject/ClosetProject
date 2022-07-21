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

public class Ex03mycolor extends Fragment {

    Button btn_g1, btn_g2, btn_g3, btn_g4;
    ColorDrawable color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ex03mycolor, container, false);

        btn_g1 = view.findViewById(R.id.btn_g1);
        btn_g2 = view.findViewById(R.id.btn_g2);
        btn_g3 = view.findViewById(R.id.btn_g3);
        btn_g4 = view.findViewById(R.id.btn_g4);

        btn_g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_g1.setBackgroundColor(Color.parseColor("#088D5D"));
                    btn_g2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_g4.setBackgroundColor(Color.parseColor("#686565"));
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
                }

            }
        });
        return view;

    }
}