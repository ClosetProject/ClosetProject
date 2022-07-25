package com.example.closetproject.Fragment;

import static kr.co.bootpay.Bootpay.finish;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.closetproject.DTO.DiagnosisDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.MainActivity;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.basketPage;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class analysisPage extends Fragment {

    private HorizontalBarChart barChart;

    Button btn_top, btn_b, btn_d, btn_skip;
    ImageView best_img1, best_img2, best_img3, best_img4;
    private String m_email, season;
    private RetrofitInterface retrofitAPI;

    public static analysisPage newInstance() {
        analysisPage fragment = new analysisPage();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   }

    public analysisPage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_analysis_page, container, false);

        m_email = GlobalVariate.getInstance().getM_email();
        btn_top = view.findViewById(R.id.btn_top);
        btn_b = view.findViewById(R.id.btn_b);
        btn_d = view.findViewById(R.id.btn_d);

            barChart = (HorizontalBarChart) view.findViewById(R.id.bar);
        getDiagnosis();

        btn_top.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    btn_top.setBackgroundColor(Color.parseColor("#FFC5BFBF"));
                    btn_top.setTextColor(Color.parseColor("#000000"));
                    btn_b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btn_d.setBackgroundColor(Color.parseColor("#FFFFFF"));

                }
            });


        btn_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                btn_top.setBackgroundColor(Color.parseColor("#FFFFFF"));
                btn_b.setTextColor(Color.parseColor("#000000"));
                btn_b.setBackgroundColor(Color.parseColor("#FFC5BFBF"));
                btn_d.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        });

        btn_d.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                btn_top.setBackgroundColor(Color.parseColor("#FFFFFF"));
                btn_d.setTextColor(Color.parseColor("#000000"));
                btn_b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                btn_d.setBackgroundColor(Color.parseColor("#FFC5BFBF"));
            }
        });

        return view;

    }
    private void getDiagnosis(){
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null) {
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getAnalysis(params).enqueue(new Callback<DiagnosisDTO>() {
                @Override
                public void onResponse(Call<DiagnosisDTO> call, Response<DiagnosisDTO> response) {
                    if(response.isSuccessful()){
                        //차트
                        DiagnosisDTO diagnosisDTO = response.body();
                        ArrayList<BarEntry> feature = new ArrayList<>();
                        feature.add(new BarEntry(diagnosisDTO.getD_l(),0));
                        feature.add(new BarEntry(diagnosisDTO.getD_a(),1));
                        feature.add(new BarEntry(diagnosisDTO.getD_b(),2));
                        feature.add(new BarEntry(diagnosisDTO.getD_s(),3));
                        feature.add(new BarEntry(diagnosisDTO.getD_v(),4));

                        ArrayList<String> featureName = new ArrayList<>();
                        featureName.add("L");
                        featureName.add("a*");
                        featureName.add("b*");
                        featureName.add("S");
                        featureName.add("V");

                        setData(feature);
                    }
                }

                @Override
                public void onFailure(Call<DiagnosisDTO> call, Throwable t) {

                }
            });
        }
    }

    private void setData(ArrayList<BarEntry> feature) {

        ArrayList<BarEntry> yVals = new ArrayList<>();

        float barwidth = 9f;
        float spaceForBar = 10f;

        // 1) 바 차트 초기화
        // 2) 데이터셋 생성(barDataSet)
        BarDataSet barDataSet = new BarDataSet(feature, "L");
        BarDataSet barDataSet2 = new BarDataSet(feature, "feature21");
        //String[] xAxisLabels = ylabel.toArray(new String[0]);
        //barDataSet.setStackLabels(xAxisLabels);


        // 3) 바 데이터 생성(barData)
        BarData barData = new BarData();
        // 4) 바 데이터에 데이터 셋 추가(addDataSet)
        barData.addDataSet(barDataSet);
        barData.addDataSet(barDataSet2);
        // 5) 바 데이터 등록(setData)
        barChart.setData(barData);
        //barChart.setData(barDat2);
    }

}

