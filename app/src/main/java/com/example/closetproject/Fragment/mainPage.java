package com.example.closetproject.Fragment;

import android.content.ActivityNotFoundException;
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

    GridView main_grid;
    ArrayList<mainVO> data;
    mainCA adapter;
    String[] s_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getLayoutInflater().inflate((R.layout.fragment_main_page), null);

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