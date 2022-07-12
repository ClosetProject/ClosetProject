package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.closetproject.Adapter.storeProductCA;
import com.example.closetproject.Adapter.storeCA;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.DTO.StoreDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneStoreActivity extends AppCompatActivity {

    GridView sho_grid;
    ArrayList<ProductDTO> productList;
    storeProductCA adapter;
    String[] s_name= {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.viling, R.drawable.p_jull, R.drawable.p_lrod, R.drawable.p_mall, R.drawable.p_pani, R.drawable.p_tano};
    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_store);
        sho_grid = findViewById(R.id.sho_grid);
        setProductAdapter();
    }

    private void setProductAdapter(){
        // 데이터 불러오기
        String sql = "SELECT A.P_CODE, A.P_NAME, A.P_IMG, A.P_CAT, A.P_PRICE, A.S_SEQ, B.S_NAME FROM TBL_PRODUCT A, TBL_STORE B WHERE B.S_SEQ = A.S_SEQ AND A.S_SEQ = :1";
        String[] header = {"P_CODE", "P_NAME", "P_IMG", "P_CAT", "P_PRICE", "S_SEQ", "S_NAME"};
        String[] params = {"1"};

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
                        sho_grid.setAdapter(adapter);
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