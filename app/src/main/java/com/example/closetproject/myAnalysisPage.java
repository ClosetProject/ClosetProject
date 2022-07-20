package com.example.closetproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myAnalysisPage extends AppCompatActivity {

    private static final int NUM_PAGES = 4; // 페이지 수
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
//    private btn_y1, btn_y2, btn_y3, btn_y4,
//            btn_g1, btn_g2, btn_g3, btn_g4, btn_b1, btn_b2, btn_b3, btn_b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_analysis_page);

        pager = findViewById(R.id.pager);
        pagerAdapter = new ScreeSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);

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