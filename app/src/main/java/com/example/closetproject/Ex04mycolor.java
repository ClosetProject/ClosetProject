package com.example.closetproject;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.example.closetproject.DTO.DiagnosisDTO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ex04mycolor extends Fragment {

    Button btn_b1, btn_b2, btn_b3, btn_b4;
    ConstraintLayout b_color1, b_color2, b_color3, b_color4;
    ColorDrawable color;
    private int[] arrColor;
    private RetrofitInterface retrofitAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ex04mycolor, container, false);

        btn_b1 = view.findViewById(R.id.btn_b1);
        btn_b2 = view.findViewById(R.id.btn_b2);
        btn_b3 = view.findViewById(R.id.btn_b3);
        btn_b4 = view.findViewById(R.id.btn_b4);

        b_color1 = view.findViewById(R.id.b_color1);
        b_color2 = view.findViewById(R.id.b_color2);
        b_color3 = view.findViewById(R.id.b_color3);
        b_color4 = view.findViewById(R.id.b_color4);

        switch(GlobalVariate.getInstance().getD_season()){
            case "WS":
                arrColor = new int[]{R.color.spring_l_blue1, R.color.spring_l_blue2,
                        R.color.spring_b_blue1, R.color.spring_b_blue2};
                break;
            case "SC":
                arrColor = new int[]{R.color.summer_m_blue1, R.color.summer_m_blue2,
                        R.color.summer_l_blue1, R.color.summer_l_blue2};
                break;
            case "AW":
                arrColor = new int[]{R.color.autumn_m_blue1, R.color.autumn_m_blue2,
                        R.color.autumn_d_blue1, R.color.autumn_d_blue2};
                break;
            case "WC":
                arrColor = new int[]{R.color.winter_b_blue1, R.color.winter_b_blue2,
                        R.color.winter_d_blue1, R.color.winter_d_blue2};
                break;
        }

        b_color1.setBackgroundResource(arrColor[0]);
        b_color2.setBackgroundResource(arrColor[1]);
        b_color3.setBackgroundResource(arrColor[2]);
        b_color4.setBackgroundResource(arrColor[3]);

        btn_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isClickable()){ // 버튼을 눌렀을 때
                    btn_b1.setBackgroundColor(Color.parseColor("#5067AC"));
                    btn_b2.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b3.setBackgroundColor(Color.parseColor("#686565"));
                    btn_b4.setBackgroundColor(Color.parseColor("#686565"));
                    GlobalVariate.getInstance().addSelf_cnt(3,1);
                    setpersonal();
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
                    GlobalVariate.getInstance().addSelf_cnt(3,2);
                    setpersonal();
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
                    GlobalVariate.getInstance().addSelf_cnt(3,3);
                    setpersonal();
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
                    GlobalVariate.getInstance().addSelf_cnt(3,4);
                    setpersonal();
                }
            }
        });
        return view;
    }

    private void setpersonal(){
        String m_email = GlobalVariate.getInstance().getM_email();
        String season = GlobalVariate.getInstance().getSelf_cnt();
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);
        params.put("season", season);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.setPersonal(params).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("fail_log",t.getMessage());
                }
            });
        }
    }
}