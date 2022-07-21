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

public class Ex01mycolor extends Fragment {

    Button btn_r1, btn_r2, btn_r3, btn_r4;
    ColorDrawable color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex01mycolor, container, false);

        btn_r1 = view.findViewById(R.id.btn_r1);
        btn_r2 = view.findViewById(R.id.btn_r2);
        btn_r3 = view.findViewById(R.id.btn_r3);
        btn_r4 = view.findViewById(R.id.btn_r4);

        btn_r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_r1.setBackgroundColor(Color.parseColor("#F62B49"));
                    btn_r2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_r4.setBackgroundColor(Color.parseColor("#686565"));
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
                }

            }
        });

//        btn_r2.setOnTouchListener(new View.OnTouchListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
//                    btn_r2.setBackgroundColor(Color.rgb(243,70,64));
//                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
//                    btn_r2.setBackgroundColor(Color.rgb(243,70,64));
//                }
//                return false;
//            }
//        });
//
//        btn_r3.setOnTouchListener(new View.OnTouchListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
//                    btn_r3.setBackgroundColor(Color.rgb(249,104,126));
//                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
//                    btn_r3.setBackgroundColor(Color.rgb(249,104,126));
//                }
//                return false;
//            }
//        });
//
//        btn_r4.setOnTouchListener(new View.OnTouchListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
//                    btn_r4.setBackgroundColor(Color.rgb(254,110,116));
//                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
//                    btn_r4.setBackgroundColor(Color.rgb(254,110,116));
//                }
//                return false;
//            }
//        });

        return view;
    }
}