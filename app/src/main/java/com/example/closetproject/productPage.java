package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class productPage extends AppCompatActivity {

    private ImageView s_basket3, iv_pd_image;
    private TextView tv_pd_name, tv_pd_price;
    private Button btn_pay;

    private RetrofitInterface retrofitAPI;
    private String p_code;
    private String m_email;
    private ArrayList<ProductDTO> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        Intent intent = getIntent();
        p_code = intent.getStringExtra("p_code");

        // View 정의
        s_basket3 = findViewById(R.id.s_basket3);
        tv_pd_name = findViewById(R.id.tv_pd_name);
        tv_pd_price = findViewById(R.id.tv_pd_);
        iv_pd_image = findViewById(R.id.iv_pd_image);

        btn_pay = findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showDialog();
            }
        });

        setProduct();
    }

    private void showDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.test_dialog_option, null);
        final Spinner spSex = (Spinner) alertLayout.findViewById(R.id.spSex);
        final Spinner spSex2 = (Spinner) alertLayout.findViewById(R.id.spSex2);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("옵션선택");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("장바구니", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(productPage.this, basketPage.class);
                startActivity(intent);
                finish();
            }
        });

        alert.setPositiveButton("구매하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String sex = String.valueOf(spSex.getSelectedItem());
                String sex1 = String.valueOf(spSex2.getSelectedItem());

                Intent intent = new Intent(productPage.this, orderPayPage.class);
                startActivity(intent);
                finish();
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();

        s_basket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(productPage.this, basketPage.class);
                startActivity(intent1);
                finish();
            }
        });

    }

    /*
     * DB 연동부
     * setProduct() - 제품정보
     * setProductPersonal() - 제품 색상 & 퍼스널 적합도
     */
    private void setProduct(){
        String sql = "SELECT A.P_CODE, A.P_NAME, A.P_IMG, A.P_CAT, A.P_PRICE, A.S_SEQ, B.S_NAME, C.COLOR_NAME, C.C_CODE" +
                "  FROM TBL_PRODUCT A, TBL_STORE B, TBL_COLOR C" +
                " WHERE A.S_SEQ = B.S_SEQ AND A.P_CODE = C.P_CODE AND A.P_CODE = :1";
        String[] header = {"P_CODE", "P_NAME", "P_IMG", "P_CAT", "P_PRICE", "S_SEQ", "S_NAME", "COLOR_NAME", "C_CODE"};
        String[] params = {p_code};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){

            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProduct(paramsVO).enqueue(new Callback<ArrayList<ProductDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<ProductDTO>> call, Response<ArrayList<ProductDTO>> response) {
                    productList = response.body();

                    tv_pd_name.setText(productList.get(0).getP_name());
                    tv_pd_price.setText(productList.get(0).getP_price());

                    String img_path = "http://121.147.185.76:8081/" + productList.get(0).getP_img() + "/BLACK.jpg";
                    Glide.with(getApplicationContext())
                                .load(img_path)
                                .error(R.drawable.noimg)
                                .into(iv_pd_image);

                }

                @Override
                public void onFailure(Call<ArrayList<ProductDTO>> call, Throwable t) {
                    Log.d("failure", t.getMessage());
                }
            });
        }
    }
}