package com.example.closetproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class f_Ex01item extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_f__ex01item, container, false);
       setInit(view);
       return view;
    }

    private void setInit(View view) {
        TextView textView36 = view.findViewById(R.id.textView36);
        ImageView imageView = view.findViewById(R.id.imageView);
        ImageView imageView1 = view.findViewById(R.id.imageView16);
        ImageView imageView2= view.findViewById(R.id.imageView18);
        ImageView imageView3 = view.findViewById(R.id.imageView5);
        ImageView imageView4 = view.findViewById(R.id.imageView14);
        ImageView imageView5 = view.findViewById(R.id.imageView17);
        ImageView imageView6 = view.findViewById(R.id.imageView19);
        ImageView imageView7 = view.findViewById(R.id.imageView15);
    }
}