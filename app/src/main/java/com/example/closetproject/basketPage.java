package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.closetproject.Adapter.basketCA;
import com.example.closetproject.Adapter.storeProductCA;
import com.example.closetproject.DTO.BasketDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.DTO.basketVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class basketPage extends AppCompatActivity {

    private Button basket_next;
    private ImageView next2;
    private ListView basket_lv;

    private ArrayList<BasketDTO> basketList;
    private basketCA adapter;
    private String m_email;

    int maxLength = 10;

    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_page);
        m_email = GlobalVariate.getInstance().getM_email();

        basket_next = findViewById(R.id.basket_next);
        next2 = findViewById(R.id.next2);
        basket_lv = findViewById(R.id.basket_lv);

        setBasketList();

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(basketPage.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
            }
        });

        basket_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(basketPage.this, orderPayPage.class);
                startActivity(intent1);
                finish();
            }
        });
    }

    /**
     * 데이터 연동부
     **/
    private void setBasketList(){
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getBasketAdapter(params).enqueue(new Callback<ArrayList<BasketDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<BasketDTO>> call, Response<ArrayList<BasketDTO>> response) {
                    basketList = response.body();
                    adapter = new basketCA(basketPage.this,R.layout.basket_list, basketList);
                    basket_lv.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<ArrayList<BasketDTO>> call, Throwable t) {

                }
            });
        }
    }
}