package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.PColorDTO;
import com.example.closetproject.DTO.PSizeDTO;
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
    private ArrayList<PColorDTO> colorList;
    private ArrayList<PSizeDTO> sizeList;
    private ArrayList<String> colorOption, sizeOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        Intent intent = getIntent();
        p_code = intent.getStringExtra("p_code");
        m_email = GlobalVariate.getInstance().getM_email();

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
        final Spinner spColor = (Spinner) alertLayout.findViewById(R.id.spSex);
        final Spinner spSize = (Spinner) alertLayout.findViewById(R.id.spSex2);
        //final EditText et_pd_cnt = (EditText) alertLayout.findViewById(R.id.et_pd_cnt);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                colorOption);
        spColor.setAdapter(arrayAdapter);

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                sizeOption);
        spSize.setAdapter(arrayAdapter);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("옵션선택");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("장바구니", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String color = String.valueOf(spColor.getSelectedItem());
                String size = String.valueOf(spSize.getSelectedItem());
                //String cnt = String.valueOf(et_pd_cnt.getText());

                //saveProductBasket(color, size, cnt);
                Intent intent = new Intent(productPage.this, basketPage.class);
                startActivity(intent);
                finish();
            }
        });

        alert.setPositiveButton("구매하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String color = String.valueOf(spColor.getSelectedItem());
                String size = String.valueOf(spSize.getSelectedItem());

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
        String sql = "SELECT A.P_CODE, A.P_NAME, A.P_IMG, A.P_CAT, A.P_PRICE, A.S_SEQ, B.S_NAME" +
                "  FROM TBL_PRODUCT A, TBL_STORE B" +
                " WHERE A.S_SEQ = B.S_SEQ AND A.P_CODE = :1";
        String[] header = {"P_CODE", "P_NAME", "P_IMG", "P_CAT", "P_PRICE", "S_SEQ", "S_NAME"};
        String[] params = {p_code};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){

            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProduct(paramsVO).enqueue(new Callback<ArrayList<ProductDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<ProductDTO>> call, Response<ArrayList<ProductDTO>> response) {
                    productList = response.body();

                    String pd_name = "[" + productList.get(0).getS_name() + "] " +productList.get(0).getP_name();
                    tv_pd_name.setText(pd_name);
                    tv_pd_price.setText(productList.get(0).getP_price());
                    setProductColor();
                    setProductSize();

                }

                @Override
                public void onFailure(Call<ArrayList<ProductDTO>> call, Throwable t) {
                    Log.d("failure", t.getMessage());
                }
            });
        }
    }

    private void setProductColor(){
        String sql = "SELECT COLOR_SEQ, COLOR_NAME, C_CODE  FROM TBL_COLOR WHERE P_CODE = :1";
        String[] header = {"COLOR_SEQ", "COLOR_NAME", "C_CODE"};
        String[] params = {p_code};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProductColor(paramsVO).enqueue(new Callback<ArrayList<PColorDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PColorDTO>> call, Response<ArrayList<PColorDTO>> response) {
                    colorList = response.body();
                    String img_path = "http://121.147.185.76:8081/" + productList.get(0).getP_img() + "/" + colorList.get(0).getColor_name() + ".jpg";
                    Glide.with(getApplicationContext())
                            .load(img_path)
                            .error(R.drawable.noimg)
                            .into(iv_pd_image);

                    colorOption = new ArrayList<String>();
                    for(int i = 0; i < colorList.size() -1 ; i++){
                        colorOption.add(colorList.get(i).getColor_name());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<PColorDTO>> call, Throwable t) {

                }
            });
        }
    }

    private void setProductSize(){
        String sql = "SELECT SIZE_SEQ, SIZE_NAME, SIZE_DESC, SIZE_PART  FROM TBL_SIZE WHERE P_CODE = :1";
        String[] header = {"SIZE_SEQ", "SIZE_NAME", "SIZE_DESC", "SIZE_PART"};
        String[] params = {p_code};

        ParamsVO paramsVO = new ParamsVO(sql, header, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProductSize(paramsVO).enqueue(new Callback<ArrayList<PSizeDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PSizeDTO>> call, Response<ArrayList<PSizeDTO>> response) {
                    sizeList = response.body();

                    sizeOption = new ArrayList<String>();
                    for(int i = 0; i < sizeList.size() -1 ; i++){
                        sizeOption.add(sizeList.get(i).getSize_name());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<PSizeDTO>> call, Throwable t) {

                }
            });
        }
    }

    private void saveProductBasket(String color, String size, String cnt){
        String sql = "INSERT INTO TBL_BASKET(P_CODE, P_CNT, M_EMAIL, P_COLOR, P_SIZE) VALUES(:1,:2,:3,:4,:5)";
        //String[] header = {"B_SEQ, P_CODE, P_CNT, M_EMAIL, P_COLOR, P_SIZE"};
        String[] params = {p_code, cnt, m_email, color, size};

        ParamsVO paramsVO = new ParamsVO(sql, params);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.saveProductBasket(paramsVO).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
    }
}