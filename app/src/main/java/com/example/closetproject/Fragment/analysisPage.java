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
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.DiagnosisDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.MainActivity;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.basketPage;
import com.example.closetproject.productPage;
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
    private TextView tv_season;
    private ImageView img_best, img_good, iv_face;
    private String m_email, season, face_img;
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
        img_best = view.findViewById(R.id.img_best);
        img_good = view.findViewById(R.id.img_good);
        iv_face = view.findViewById(R.id.iv_face);
        tv_season = view.findViewById(R.id.tv_season);
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
                        DiagnosisDTO diagnosisDTO = response.body();
                        season = diagnosisDTO.getD_result();
                        String txt_season = "봄웜";
                        String file_path = diagnosisDTO.getFace_img();
                        Glide.with(getContext())
                                .load(file_path)
                                .error(R.drawable.noimg)
                                .into(iv_face);

                        switch (season.substring(0,2)){
                            case "SW":
                                img_best.setImageResource(R.drawable.sw_best);
                                img_good.setImageResource(R.drawable.sw_good);
                                txt_season = "봄 웜";
                                break;
                            case "SC":
                                img_best.setImageResource(R.drawable.sc_best);
                                img_good.setImageResource(R.drawable.sc_good);
                                txt_season = "여름 쿨";
                                break;
                            case "AW":
                                img_best.setImageResource(R.drawable.aw_best);
                                img_good.setImageResource(R.drawable.aw_good);
                                txt_season = "가을 웜";
                                break;
                            case "WC":
                                img_best.setImageResource(R.drawable.wc_best);
                                img_good.setImageResource(R.drawable.wc_good);
                                txt_season = "겨울 쿨";
                                break;
                        }

                        tv_season.setText("당신의 퍼스널 컬러는 " + txt_season + " 입니다");

                        //Chart
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

    private void getMember(){
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null) {
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getAnalysis(params).enqueue(new Callback<DiagnosisDTO>() {
                @Override
                public void onResponse(Call<DiagnosisDTO> call, Response<DiagnosisDTO> response) {
                    if(response.isSuccessful()){
                        DiagnosisDTO diagnosisDTO = response.body();
                        season = diagnosisDTO.getD_result();
                        String txt_season = "봄웜";

                        switch (season.substring(0,2)){
                            case "SW":
                                img_best.setImageResource(R.drawable.sw_best);
                                img_good.setImageResource(R.drawable.sw_good);
                                txt_season = "봄 웜";
                                break;
                            case "SC":
                                img_best.setImageResource(R.drawable.sc_best);
                                img_good.setImageResource(R.drawable.sc_good);
                                txt_season = "여름 쿨";
                                break;
                            case "AW":
                                img_best.setImageResource(R.drawable.aw_best);
                                img_good.setImageResource(R.drawable.aw_good);
                                txt_season = "가을 웜";
                                break;
                            case "WC":
                                img_best.setImageResource(R.drawable.wc_best);
                                img_good.setImageResource(R.drawable.wc_good);
                                txt_season = "겨울 쿨";
                                break;
                        }

                        tv_season.setText("당신의 퍼스널 컬러는 " + txt_season + " 입니다");

                        //Chart
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

