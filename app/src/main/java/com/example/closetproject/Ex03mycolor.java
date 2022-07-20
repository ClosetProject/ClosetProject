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

        btn_g1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ResourceAsColor", "ClickableViewAccessibility"})
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                String data = btn_g1.getBackground().toString();
                Log.d("red : ", data);

                view.setSelected(!view.isSelected());
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_g1.setBackgroundColor(Color.rgb(8,141,93));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP) { // 버튼을 눌렀다가 땠을 때
                    btn_g1.setBackgroundColor(Color.rgb(8, 141, 93));
                }
                return false;
            }
        });

        btn_g2.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_g2.setBackgroundColor(Color.rgb(46,162,91));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_g2.setBackgroundColor(Color.rgb(46,162,91));
                }
                return false;
            }
        });

        btn_g3.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_g3.setBackgroundColor(Color.rgb(130,199,133));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_g3.setBackgroundColor(Color.rgb(130,199,133));
                }
                return false;
            }
        });

        btn_g4.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){ // 버튼을 눌렀을 때
                    btn_g4.setBackgroundColor(Color.rgb(151,213,104));
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){ // 버튼을 눌렀다가 땠을 때
                    btn_g4.setBackgroundColor(Color.rgb(151,213,104));
                }
                return false;
            }
        });
        return view;

    }
}