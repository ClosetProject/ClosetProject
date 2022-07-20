package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.PColorDTO;
import com.example.closetproject.DTO.PSizeDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashMap;

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
        tv_pd_price = findViewById(R.id.tv_pd_price);
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
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);
        params.put("p_code", p_code);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){

            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getProduct(params).enqueue(new Callback<ProductDTO>() {
                @Override
                public void onResponse(Call<ProductDTO> call, Response<ProductDTO> response) {
                    ProductDTO product = response.body();
                    ArrayList<PColorDTO> colorList = null;
                    ArrayList<PSizeDTO> sizeList = null;

                    String pd_name = "[" + product.getS_name() + "] " + product.getP_name() + "원";

                    tv_pd_name.setText(pd_name);
                    tv_pd_price.setText(product.getP_price());

                    // 색상 세팅
                    if(product.getColorList().size() > 0){
                        colorList = product.getColorList();
                        String[] imgList = new String[colorList.size()];
                        for(int c = 0; c < colorList.size(); c++){
                            String colorName = colorList.get(c).getColor_name();
                            String imgPath = GlobalVariate.getInstance().getBaseURL() + product.getP_img() + "/" + colorName + ".jpg";
                            imgList[c] = imgPath;
                        }

                        Glide.with(productPage.this)
                                .load(imgList[0])
                                .error(R.drawable.noimg)
                                .into(iv_pd_image);
;
                    }else{
                        Glide.with(productPage.this)
                                .load(R.drawable.noimg)
                                .error(R.drawable.noimg)
                                .into(iv_pd_image);
                    }
                    
                    // 사이즈 세팅
                    if(product.getSizeList().size() > 0){
                        sizeList = product.getSizeList();
                    }

                    // 색상추가
                    ChipGroup color_group = (ChipGroup)findViewById(R.id.color_group);
                    for(int i = 0; i < colorList.size(); i++){
                        String color_name = colorList.get(i).getColor_name();
                        String color_code = colorList.get(i).getC_code();

                        Chip colorChip = new Chip(productPage.this);
                        colorChip = setColorChip(colorChip, color_name, color_code);
                        color_group.addView(colorChip);
                    }


                    ChipGroup size_group = (ChipGroup)findViewById(R.id.size_group);
                    String size_name = "";
                    for(int i = 0;i < sizeList.size(); i++){
                        if(!sizeList.get(i).getSize_name().equals(size_name)){
                            size_name = sizeList.get(i).getSize_name();

                            Chip sizeChip = new Chip(productPage.this);
                            sizeChip = setSizeChip(sizeChip, size_name);
                            size_group.addView(sizeChip);
                        }
                    }

                }
                @Override
                public void onFailure(Call<ProductDTO> call, Throwable t) {
                    Log.d("failure", t.getMessage());
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

    private Chip setColorChip(Chip color, String colorName, String colorCode){
        color.setText(colorName);
        color.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor(colorCode)));
        color.setCheckable(true);
        color.setTextSize((float)13);
        color.setGravity(View.TEXT_ALIGNMENT_CENTER);
        return color;
    }

    private Chip setSizeChip(Chip size, String sizeName){
        size.setText(sizeName);
        size.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        size.setChipStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        size.setChipStrokeWidth((float)3);
        size.setCheckable(true);
        size.setTextSize((float)13);
        size.setGravity(View.TEXT_ALIGNMENT_CENTER);
        return size;
    }
}