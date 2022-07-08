package com.example.closetproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.closetproject.JoinActivity;
import com.example.closetproject.MainActivity;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class storePage extends Fragment {

    ImageView s_img, s_basket;
    TextView s_store_name, tv_num, s_concept;

    private RetrofitInterface retrofitAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_page, container, false);

        s_img = view.findViewById(R.id.s_img);
        s_basket = view.findViewById(R.id.s_basket);
        s_store_name = view.findViewById(R.id.s_store_name);
        tv_num = view.findViewById(R.id.tv_num);
        s_concept = view.findViewById(R.id.s_concept);

        int img = s_img.getImageAlpha();
        String store_name = s_store_name.getText().toString();
        String seq = tv_num.getText().toString();
        String concept = s_concept.getText().toString();


        String sql = "select s_seq, s_name, s_img, s_concept from tbl_store";
        String[] header = {"s_seq", "s_name", "s_img", "s_concept"};
        String[] params = {String.valueOf(img), store_name, seq, concept};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();


        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.joinMember(paramsVO).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){

                    }else{
                        Log.d("res","실패");
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("res", t.getMessage());
                }
            });
        }

        return view;
    }
}