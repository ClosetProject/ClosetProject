package com.example.closetproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.closetproject.DTO.DiagnosisDTO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class myAnalysisPage extends AppCompatActivity {

    private static final int NUM_PAGES = 4; // 페이지 수
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

    private String m_email, season;
    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_analysis_page);

        m_email = GlobalVariate.getInstance().getM_email();
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getAnalysis(params).enqueue(new Callback<DiagnosisDTO>() {
                @Override
                public void onResponse(Call<DiagnosisDTO> call, Response<DiagnosisDTO> response) {
                    DiagnosisDTO diagnosisDTO = response.body();
                    season = diagnosisDTO.getD_result();
                    GlobalVariate.getInstance().setD_season(season);
                    pager = findViewById(R.id.pager);
                    pagerAdapter = new ScreeSlidePagerAdapter(myAnalysisPage.this);
                    pager.setAdapter(pagerAdapter);
                }
                @Override
                public void onFailure(Call<DiagnosisDTO> call, Throwable t) {
                    Log.d("fail_Log",t.getMessage());
                }
            });
        }
    }

    // 프래그먼트와 이어주는 것
    private class ScreeSlidePagerAdapter extends FragmentStateAdapter {
        public ScreeSlidePagerAdapter(myAnalysisPage ma) {
            super(ma);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position==0) return new Ex01mycolor();
            else if (position==1) return new Ex02mycolor();
            else if (position==2) return new Ex03mycolor();
            else return new Ex04mycolor();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES; // 페이지 수 지정
        }
    }
}