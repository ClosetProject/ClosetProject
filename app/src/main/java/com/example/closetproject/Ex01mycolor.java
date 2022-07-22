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

import com.example.closetproject.Retrofit_API.RetrofitInterface;

public class Ex01mycolor extends Fragment {

    Button btn_r1, btn_r2, btn_r3, btn_r4;
    ColorDrawable color;

    private RetrofitInterface retrofitAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex01mycolor, container, false);

        btn_r1 = view.findViewById(R.id.btn_r1);
        btn_r2 = view.findViewById(R.id.btn_r2);
        btn_r3 = view.findViewById(R.id.btn_r3);
        btn_r4 = view.findViewById(R.id.btn_r4);



        // if(d_result().equals("spring")){

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

        return view;
    }


}