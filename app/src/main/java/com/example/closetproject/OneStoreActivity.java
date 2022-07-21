package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.closetproject.Adapter.storeProductCA;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneStoreActivity extends AppCompatActivity {

    private ArrayList<ProductDTO> productList;
    private storeProductCA adapter;
    private RetrofitInterface retrofitAPI;
    private String s_seq,m_email;
    private GridView gv_sp_list;
    private TextView tv_outer, tv_sab, tv_top, tv_ops, tv_knit;
    private ImageView iv_all, iv_storeback, s_basket2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_store);

        Intent intent = getIntent();
        s_seq = intent.getStringExtra("s_seq");
        m_email = GlobalVariate.getInstance().getM_email();

        iv_storeback = findViewById(R.id.iv_storeback);
        iv_storeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        s_basket2 = findViewById(R.id.s_basket2);
        s_basket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent basketActivity = new Intent(OneStoreActivity.this, basketPage.class);
                startActivity(basketActivity);
            }
        });

        gv_sp_list = findViewById(R.id.gv_sp_list);
        gv_sp_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent product_intent = new Intent(OneStoreActivity.this, productPage.class);
                product_intent.putExtra("p_code", productList.get(i).getP_code());
                startActivity(product_intent);
            }
        });

        iv_all = findViewById(R.id.iv_all);
        iv_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_knit.setTextColor(Color.BLACK);
                tv_ops.setTextColor(Color.BLACK);
                tv_outer.setTextColor(Color.BLACK);
                tv_sab.setTextColor(Color.BLACK);
                tv_top.setTextColor(Color.BLACK);
                setProductAdapter("ALL");
            }
        });

        tv_outer = findViewById(R.id.tv_outer);
        tv_outer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setchoiceDesign((TextView) view);
                setProductAdapter("OUT");
            }
        });

        tv_sab = findViewById(R.id.tv_sab);
        tv_sab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setchoiceDesign((TextView) view);
                setProductAdapter("SAB");
            }
        });

        tv_top = findViewById(R.id.tv_top);
        tv_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setchoiceDesign((TextView) view);
                setProductAdapter("TOP");
            }
        });

        tv_ops = findViewById(R.id.tv_ops);
        tv_ops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setchoiceDesign((TextView) view);
                setProductAdapter("OPS");
            }
        });

        tv_knit = findViewById(R.id.tv_knit);
        tv_knit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setchoiceDesign((TextView) view);
                setProductAdapter("KNI");
            }
        });

        setProductAdapter("ALL");
    }

    private void setProductAdapter(String p_cat){
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);
        params.put("s_seq", s_seq);
        params.put("p_cat", p_cat);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProductAdapter(params).enqueue(new Callback<ArrayList<ProductDTO>>() {
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

    private void setchoiceDesign(TextView tv){
        tv_knit.setTextColor(Color.BLACK);
        tv_ops.setTextColor(Color.BLACK);
        tv_outer.setTextColor(Color.BLACK);
        tv_sab.setTextColor(Color.BLACK);
        tv_top.setTextColor(Color.BLACK);
        tv.setTextColor(Color.parseColor("#FF54E5F3"));
    }
}