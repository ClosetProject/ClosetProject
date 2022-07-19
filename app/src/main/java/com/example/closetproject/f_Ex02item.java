package com.example.closetproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class f_Ex02item extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f__ex02item, container, false);
        setInit(view);
        return view;
    }

    private void setInit(View view) {
        TextView textView37 = view.findViewById(R.id.textView37);
        ImageView imageView = view.findViewById(R.id.imageView38);
        ImageView imageView1 = view.findViewById(R.id.imageView39);
        ImageView imageView2= view.findViewById(R.id.imageView40);
        ImageView imageView3 = view.findViewById(R.id.imageView41);
        ImageView imageView4 = view.findViewById(R.id.imageView42);
        ImageView imageView5 = view.findViewById(R.id.imageView44);
        ImageView imageView6 = view.findViewById(R.id.imageView45);
        ImageView imageView7 = view.findViewById(R.id.imageView46);
    }
}