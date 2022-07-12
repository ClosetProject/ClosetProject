package com.example.closetproject.Fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.closetproject.Adapter.storeCA;
import com.example.closetproject.DTO.StoreDTO;
import com.example.closetproject.OneStoreActivity;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class storePage extends Fragment {

    ImageView basket_store;
    ListView store_list;
    ArrayList<StoreDTO> storeList;
    storeCA adapter;

    private RetrofitInterface retrofitAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getLayoutInflater().inflate((R.layout.fragment_store_page), null);


        basket_store = view.findViewById(R.id.basket_store);
        store_list = view.findViewById(R.id.store_list);

        basket_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent basket_intent = (Intent) new Intent();
                basket_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                basket_intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.basketPage"));
                startActivity(basket_intent);
            }
        });

        store_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent store_intent = new Intent(getActivity(), OneStoreActivity.class);
                store_intent.putExtra("s_seq", storeList.get(i).getS_seq());
                startActivity(store_intent);
            }
        });

        setStoreAdapter();

        return view;
    }

    private void setStoreAdapter(){
        // 데이터 불러오기
        String sql = "SELECT S_SEQ, S_NAME, S_IMG, S_TEL, S_ADDR, '#청순 #유니크' AS S_DESC FROM TBL_STORE";
        String[] header = {"S_SEQ", "S_NAME", "S_IMG", "S_TEL", "S_ADDR", "S_DESC"};
        String[] params = {"null"};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getStoreList(paramsVO).enqueue(new Callback<ArrayList<StoreDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<StoreDTO>> call, Response<ArrayList<StoreDTO>> response) {
                    if(response.isSuccessful()){
                        storeList = response.body();
                        adapter = new storeCA(getActivity(), R.layout.fragment_store_list, storeList);
                        store_list.setAdapter(adapter);
                    }
                    else{
                        Log.d("failure", "불러올 쇼핑몰이 없습니다");
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<StoreDTO>> call, Throwable t) {
                    Log.d("failure", t.getMessage());
                }
            });
        }
    }
}