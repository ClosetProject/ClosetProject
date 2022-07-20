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

        btn_b1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ResourceAsColor", "ClickableViewAccessibility"})
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                String data = btn_b1.getBackground().toString();
                Log.d("red : ", data);

                view.setSelected(!view.isSelected());
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_b1.setBackgroundColor(Color.rgb(80,103,172));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP) { // 버튼을 눌렀다가 땠을 때
                    btn_b1.setBackgroundColor(Color.rgb(80, 103, 172));
                }
                return false;
            }
        });

        btn_b2.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_b2.setBackgroundColor(Color.rgb(41,119,190));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_b2.setBackgroundColor(Color.rgb(41,119,190));
                }
                return false;
            }
        });

        btn_b3.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_b3.setBackgroundColor(Color.rgb(108,156,198));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_b3.setBackgroundColor(Color.rgb(108,156,198));
                }
                return false;
            }
        });

        btn_b4.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_b4.setBackgroundColor(Color.rgb(105,165,205));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_b4.setBackgroundColor(Color.rgb(105,165,205));
                }
                return false;
            }
        });
        return view;

    }
}