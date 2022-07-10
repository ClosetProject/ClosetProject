package com.example.closetproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.closetproject.Adapter.storeCA;
import com.example.closetproject.DTO.storeVO;

import java.util.ArrayList;

public class storePage extends Fragment {

    ImageView s_basket;
    ListView store_list;
    ArrayList<storeVO> data;
    storeCA adapter;
    String[] p_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] s_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};

    // private RetrofitInterface retrofitAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getLayoutInflater().inflate((R.layout.fragment_store_page), null);

        store_list = view.findViewById(R.id.store_list);
        data = new ArrayList<storeVO>();

        for (int i = 0; i<s_name.length; i++){
            data.add(new storeVO((i+1)+"", s_name[i], "# 청순 # 하늘하늘"));
        }

        adapter = new storeCA(getActivity(), R.layout.fragment_store_list,data);

        store_list.setAdapter(adapter);



//        s_img = view.findViewById(R.id.s_img);
//        s_basket = view.findViewById(R.id.s_basket);
//        s_store_name = view.findViewById(R.id.s_store_name);
//        tv_num = view.findViewById(R.id.tv_num);
//        s_concept = view.findViewById(R.id.s_concept);

//        int img = s_img.getImageAlpha();
//        String store_name = s_store_name.getText().toString();
//        String seq = tv_num.getText().toString();
//        String concept = s_concept.getText().toString();
//
//
//        String sql = "select s_seq, s_name, s_img, s_concept from tbl_store";
//        String[] header = {"s_seq", "s_name", "s_img", "s_concept"};
//        String[] params = {String.valueOf(img), store_name, seq, concept};
//
//        ParamsVO paramsVO = new ParamsVO(sql, header, params);
//        RetrofitClient retrofitClient = RetrofitClient.getInstance();
//
//
//        if(retrofitClient != null){
//            retrofitAPI = RetrofitClient.getRetrofitAPI();
//            retrofitAPI.joinMember(paramsVO).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    if(response.isSuccessful()){
//
//                    }else{
//                        Log.d("res","실패");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    Log.d("res", t.getMessage());
//                }
//            });
//        }

        return view;
    }
}