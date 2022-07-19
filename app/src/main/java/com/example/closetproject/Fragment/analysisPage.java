package com.example.closetproject.Fragment;

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

import com.example.closetproject.R;
import com.github.mikephil.charting.charts.BarChart;

import java.util.Objects;

public class analysisPage extends Fragment {

    private ViewPager2 viewpager;
    private ViewGroup viewGroup; // 뷰 객체 선언
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

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_analysis_page, container, false);

        setInint();
        return viewGroup;

    }

    private void setInint() {
        viewpager = viewGroup.findViewById(R.id.viewpager);
        FragmentStateAdapter SetupPagerAdapter = new FragmentStateAdapter(getActivity()) {
            @Override
            public int getItemCount() {
                return 0;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return null;
            }
        };
        viewpager.setAdapter(SetupPagerAdapter); // 프래그먼트를 파라미터로 받고 ViewPager2에 전달 받음
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); // 방향은 가로로
        viewpager.setOffscreenPageLimit(3); // 페이지 한계 지정 갯수
        viewpager.setCurrentItem(1000); //무제한으로 스크롤 되는 것 처럼 표현됨

        final float pageMargin = (float) getResources().getDimensionPixelOffset(R.dimen.pageMargin); // 페이지끼리 간격
        final float pageOffset = (float) getResources().getDimensionPixelOffset(R.dimen.offset); // 페이지 보이는 정도

        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageSelected(int position){
                super.onPageSelected(position);
            }
        });

        viewpager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float offset = position * -(2*pageOffset + pageMargin);
                if (-1>position){
                    page.setTranslationX(-offset);
                }else if(1 >= position){
                    float scaleFactor = Math.max(0.7f, 1 -Math.abs(position - 0.14285715f));
                    page.setTranslationX(offset);
                    page.setScaleY(scaleFactor);
                    page.setAlpha(scaleFactor);
                }else{
                    page.setAlpha(0f);
                    page.setTranslationX(offset);
                }
            }
        });

    }

}