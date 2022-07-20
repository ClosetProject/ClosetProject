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

        btn_y1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ResourceAsColor", "ClickableViewAccessibility"})
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                String data = btn_y1.getBackground().toString();
                Log.d("red : ", data);

                view.setSelected(!view.isSelected());
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_y1.setBackgroundColor(Color.rgb(246,200,39));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP) { // 버튼을 눌렀다가 땠을 때
                    btn_y1.setBackgroundColor(Color.rgb(246, 200, 39));
                }
                return false;
            }
        });

        btn_y2.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_y2.setBackgroundColor(Color.rgb(254,242,38));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_y2.setBackgroundColor(Color.rgb(254,242,38));
                }
                return false;
            }
        });

        btn_y3.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_y3.setBackgroundColor(Color.rgb(253,210,118));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_y3.setBackgroundColor(Color.rgb(253,210,118));
                }
                return false;
            }
        });

        btn_y4.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_y4.setBackgroundColor(Color.rgb(252,243,128));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_y4.setBackgroundColor(Color.rgb(252,243,128));
                }
                return false;
            }
        });
        return view;
    }
}