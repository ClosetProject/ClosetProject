package com.example.closetproject.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.closetproject.R;
import com.github.mikephil.charting.charts.BarChart;

public class analysisPage extends Fragment {

    BarChart bar;

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
        // Inflate the layout for this fragment
      View view =inflater.inflate(R.layout.fragment_analysis_page, container, false);
//
//        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/ProductSans.ttf");
//
//        bar = (BarChart)view.findViewById(R.id.bar);

        return view;

    }
}