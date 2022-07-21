package com.example.closetproject.Fragment;

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

import com.example.closetproject.R;
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
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class analysisPage extends Fragment {

    private HorizontalBarChart bar;

    Button btn_top, btn_b, btn_d;
    ImageView best_img1, best_img2, best_img3, best_img4;
    BarData data1;

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


            btn_top = view.findViewById(R.id.btn_top);
            btn_b = view.findViewById(R.id.btn_b);
            btn_d = view.findViewById(R.id.btn_d);
            data1 = new BarData();

            bar = (HorizontalBarChart) view.findViewById(R.id.bar);
            setData(4,100);

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

    private void setData(int count, int range) {

        ArrayList<BarEntry> yVals = new ArrayList<>();

        float barwidth = 9f;
        float spaceForBar = 10f;

       // BarData data = new BarData();

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();


        ArrayList<String> labels = new ArrayList<>();
        labels.add("봄 웜");
        labels.add("여름 쿨");
        labels.add("가을 웜");
        labels.add("겨울 쿨");
        int dataCount = 0;
        ArrayList<String> ylabels = new ArrayList<>();
        for (int i=0;i<4;++i) {
            BarEntry entry = new BarEntry(count,(i+1));
            yVals.add(entry);
            ylabels.add(" "+i);
            dataCount++;
        }

        for (int i = 0; i < 4; i++) {
            float val = (float) (Math.random() * range);
            yVals.add(new BarEntry(i * count, val));
        }
        BarDataSet set;

        set = new BarDataSet(yVals, "Data Set");
        BarData data = new BarData(set);


        List<IBarDataSet> dataSets = new ArrayList<>();
        BarDataSet bds = new BarDataSet(yVals, "");
        bds.setColor(Color.parseColor("#000000"));
        String[] xAxisLabels = labels.toArray(new String[0]);
//        //String[] yAxisLabels = labels.toArray(new String[0]);
        bds.setStackLabels(xAxisLabels);
        dataSets.add(bds);
        data.addDataSet(bds);
        data.setDrawValues(true);
//
//
        bar.getDescription().setEnabled(false); // chart 밑에 description 표시 유무
        bar.setTouchEnabled(false); // 터치 유무
        bar.getLegend().setEnabled(false); // 차트 범례
//
        XAxis xAxis = bar.getXAxis();
        xAxis.setDrawAxisLine(false); // 선 제거
        xAxis.setGranularity(1f);
        xAxis.setTextSize(12f);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        xAxis.setGridLineWidth(25f);
        xAxis.setGridColor(Color.parseColor("#FFFFFF"));
        xAxis.setLabelCount(dataCount+1);
        xAxis.setXOffset(10);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // x축 데이터 표시 위치
//
        CategoryBarChartXaxisFormatter xaxisFormatter = new CategoryBarChartXaxisFormatter(xAxisLabels);
        xAxis.setValueFormatter(xaxisFormatter);
//
        // YAxis(Left) (수평 막대 기준 아래쪽) - 선 유무, 데이터 최솟값/최댓값, label 유무
        YAxis axisLeft = bar.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setAxisMinimum(0f); // 최솟값
        axisLeft.setAxisMaximum(100f); // 최댓값
        axisLeft.setGranularity(1f); // 값 만큼 라인선 설정
        axisLeft.setDrawLabels(false); // label 삭제
//
//        // YZxis(Right) (수평 막대 기준 위쪽) - 사이즈, 선 유무
        YAxis axisRight = bar.getAxisRight();
        axisRight.setTextSize(15f);
        axisRight.setDrawLabels(false);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawAxisLine(false);

        bar.setData(data);
        bar.setFitBars(true);
        bar.setDescription(null);

    }

        public class CategoryBarChartXaxisFormatter extends ValueFormatter implements IAxisValueFormatter {

            private String[] mValues;

            public CategoryBarChartXaxisFormatter(String[] values) {
                this.mValues = values;
            }

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                int val = (int) value;
                String label = "";
                if (val >= 0 && val < mValues.length) {
                    label = mValues[val];
                } else {
                    label = "";
                }
                return label;
            }
        }

    }

