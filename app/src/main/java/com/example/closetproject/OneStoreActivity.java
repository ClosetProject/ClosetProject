package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.closetproject.Adapter.storeProductCA;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneStoreActivity extends AppCompatActivity {
    private ArrayList<ProductDTO> productList;
    private storeProductCA adapter;
    private RetrofitInterface retrofitAPI;
    private String s_seq;
    private GridView gv_sp_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        s_seq = intent.getStringExtra("s_seq");

        setContentView(R.layout.activity_one_store);
        gv_sp_list = findViewById(R.id.gv_sp_list);
        setProductAdapter();
    }

    private void setProductAdapter(){
        // 데이터 불러오기
        String sql = "SELECT A.P_CODE, A.P_NAME, A.P_IMG, A.P_CAT, A.P_PRICE, A.S_SEQ, B.S_NAME FROM TBL_PRODUCT A, TBL_STORE B WHERE B.S_SEQ = A.S_SEQ AND A.S_SEQ = :1";
        String[] header = {"P_CODE", "P_NAME", "P_IMG", "P_CAT", "P_PRICE", "S_SEQ", "S_NAME"};
        String[] params = {s_seq};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProductAdapter(paramsVO).enqueue(new Callback<ArrayList<ProductDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<ProductDTO>> call, Response<ArrayList<ProductDTO>> response) {
                    if(response.isSuccessful()){
                        productList = response.body();
                        adapter = new storeProductCA(OneStoreActivity.this, R.layout.store_product_item, productList);
                        gv_sp_list.setAdapter(adapter);
                    }
                    else{
                        Log.d("failure", "불러올 제품이 없습니다");
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<ProductDTO>> call, Throwable t) {
                    Log.d("failure", t.getMessage());
                }
            });
        }
    }
}