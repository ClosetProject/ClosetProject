package com.example.closetproject.Fragment;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.closetproject.Adapter.mainCA;
import com.example.closetproject.DTO.mainVO;
import com.example.closetproject.R;

import java.util.ArrayList;

public class mainPage extends Fragment {

    ImageView basket_main;
    GridView main_grid;
    ArrayList<mainVO> data;
    mainCA adapter;
    String[] s_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.com_i_1, R.drawable.com_o_1, R.drawable.com_r_1, R.drawable.com_t_1, R.drawable.com_y_1, R.drawable.com_w_1};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getLayoutInflater().inflate((R.layout.fragment_main_page), null);

        basket_main = view.findViewById(R.id.basket_main);

        basket_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (Intent) new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.basketPage"));
                startActivity(intent);
            }
        });

        // 유튜브 링크 적용
        final ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.youtube.com/watch?v=H9vAfkUyF4Q="+getActivity().getPackageName()));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent weblntent = new Intent(Intent.ACTION_VIEW);
                    weblntent.setData(Uri.parse("http://www.youtube.com/watch?v=H9vAfkUyF4Q="+getActivity().getPackageName()));
                    if (weblntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(weblntent);
                    }
                }

            }
        });

        final ImageView imageView1 = (ImageView)view.findViewById(R.id.img2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=D9Id0nd8TW4Q="+getActivity().getPackageName()));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent weblntent = new Intent(Intent.ACTION_VIEW);
                    weblntent.setData(Uri.parse("https://www.youtube.com/watch?v=D9Id0nd8TW4="+getActivity().getPackageName()));
                    if (weblntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(weblntent);
                    }
                }

            }
        });

        final ImageView imageView2 = (ImageView)view.findViewById(R.id.you_img1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=1bR0Ot40kdc="+getActivity().getPackageName()));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent weblntent = new Intent(Intent.ACTION_VIEW);
                    weblntent.setData(Uri.parse("https://www.youtube.com/watch?v=1bR0Ot40kdc="+getActivity().getPackageName()));
                    if (weblntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(weblntent);
                    }
                }

            }
        });


        // grid 화면 적용
        main_grid = view.findViewById(R.id.main_grid);
        data = new ArrayList<mainVO>();

        for (int i = 0; i<s_name.length; i++){
            data.add(new mainVO(s_name[i], img[i]));
        }

        adapter = new mainCA(getActivity(), R.layout.fragment_main_list,data);

        main_grid.setAdapter(adapter);

        return view;

    }

}