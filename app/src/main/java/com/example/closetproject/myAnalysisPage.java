package com.example.closetproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class myAnalysisPage extends AppCompatActivity {

    private static final int NUM_PAGES = 3; // 페이지 수
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

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
            else return new Ex03mycolor();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES; // 페이지 수 지정
        }
    }
}