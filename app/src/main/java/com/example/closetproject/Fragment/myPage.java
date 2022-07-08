package com.example.closetproject.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.closetproject.Adapter.myPageCA;
import com.example.closetproject.DTO.myPageVO;
import com.example.closetproject.R;

import java.util.ArrayList;

public class myPage extends Fragment {

    GridView my_grid;
    ArrayList<myPageVO> data;
    myPageCA adapter;
    String[] p_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] s_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);

        my_grid = view.findViewById(R.id.my_grid);
        data = new ArrayList<myPageVO>();


        for (int i = 0; i<s_name.length; i++){
            data.add(new myPageVO(s_name[i], p_name[i], img[i], "20,000원"));
        }

        adapter = new myPageCA(getActivity().getApplicationContext(), R.layout.fragment_my_list,data);

        my_grid.setAdapter(adapter);

        return view;
    }
}