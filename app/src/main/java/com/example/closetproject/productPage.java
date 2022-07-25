package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.BasketDTO;
import com.example.closetproject.DTO.MyPageDTO;
import com.example.closetproject.DTO.PColorDTO;
import com.example.closetproject.DTO.PSizeDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class productPage extends AppCompatActivity {

    private ChipGroup color_group, size_group;
    private ImageView s_basket3, iv_pd_image, product_hart;
    private TextView tv_pd_name, tv_pd_price;
    private Button btn_pay;

    private RetrofitInterface retrofitAPI;
    private String p_code, m_email, wish_yn, img_path;
    private ArrayList<PColorDTO> colorList;
    private ArrayList<PSizeDTO> sizeList;

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

        color_group = findViewById(R.id.color_group);
        size_group = findViewById(R.id.size_group);

        btn_pay = findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                int color = color_group.getCheckedChipId();
                int size = size_group.getCheckedChipId();

                if(color == -1 || size == -1){
                    AlertDialog.Builder checkDial = new AlertDialog.Builder(productPage.this);
                    checkDial.setMessage("색상/사이즈를 선택해주세요");
                    checkDial.setPositiveButton("확인",null);
                    checkDial.show();
                }
                else{
                    setBasket(color, size, 1);
                    color_group.clearCheck();
                    size_group.clearCheck();
                }
            }
        });

        product_hart = findViewById(R.id.product_hart);
        product_hart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                HashMap<String, String> params = new HashMap<>();
                params.put("m_email", m_email);
                params.put("p_code", p_code);
                RetrofitClient retrofitClient = RetrofitClient.getInstance();
                RetrofitClient.getRetrofitAPI().setWishlist(params).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()){
                            if(wish_yn.equals("N")){
                                wish_yn = "Y";
                                product_hart.setImageResource(R.drawable.heart2);
                            }else{
                                wish_yn = "N";
                                product_hart.setImageResource(R.drawable.heart1);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("failure", t.getMessage());
                    }
                });
            }
        });

        setProduct();
        setColorList();
        setSizeList();
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

                    img_path = product.getP_img();
                    String pd_name = "[" + product.getS_name() + "] " + product.getP_name();
                    tv_pd_name.setText(pd_name);
                    tv_pd_price.setText(product.getP_price() + " 원");

                    //찜여부
                    wish_yn = product.getWish_yn();
                    if(wish_yn.equals("Y")){
                        product_hart.setImageResource(R.drawable.heart2);
                    }else{
                        product_hart.setImageResource(R.drawable.heart1);
                    }
                }
                @Override
                public void onFailure(Call<ProductDTO> call, Throwable t) {
                    Log.d("failure", t.getMessage());
                }
            });
        }
    }

    private void setColorList(){
        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", m_email);
        params.put("p_code", p_code);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null) {
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getColorList(params).enqueue(new Callback<ArrayList<PColorDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PColorDTO>> call, Response<ArrayList<PColorDTO>> response) {
                    if (response.isSuccessful()) {
                        colorList = response.body();
                        String[] imgList = new String[colorList.size()];
                        for (int c = 0; c < colorList.size(); c++) {
                            String colorName = colorList.get(c).getColor_name();
                            String imgPath = GlobalVariate.getInstance().getBaseURL() + img_path + colorName + ".jpg";
                            imgList[c] = imgPath;
                        }

                        Glide.with(productPage.this)
                                .load(imgList[0])
                                .error(R.drawable.noimg)
                                .into(iv_pd_image);


                        // 색상추가
                        ChipGroup color_group = (ChipGroup) findViewById(R.id.color_group);
                        for (int i = 0; i < colorList.size(); i++) {
                            PColorDTO colorDTO = colorList.get(i);

                            Chip colorChip = new Chip(productPage.this);
                            colorChip = setColorChip(colorChip, colorDTO);
                            color_group.addView(colorChip);
                        }

                        TextView tv_best = findViewById(R.id.tv_best);
                        TextView tv_good = findViewById(R.id.tv_good);
                        TextView tv_worst = findViewById(R.id.tv_worst);
                        TextView tv_color = findViewById(R.id.tv_color);

                        tv_best.setTextColor(Color.parseColor("#FFd3d3d3"));
                        tv_good.setTextColor(Color.parseColor("#FFd3d3d3"));
                        tv_worst.setTextColor(Color.parseColor("#FFd3d3d3"));

                        for (int i = 0; i < colorList.size(); i++) {
                            if (colorList.get(i).getP_grade().equals("BEST")) {
                                ConstraintLayout cst = findViewById(R.id.iv_best);
                                cst.setBackgroundColor(Color.parseColor(colorList.get(i).getC_code()));
                                tv_best.setTextColor(Color.parseColor("#000000"));
                                tv_color.setText(colorList.get(i).getColor_name());
                            } else if (colorList.get(i).getP_grade().equals("GOOD")) {
                                ConstraintLayout cst = findViewById(R.id.iv_good);
                                cst.setBackgroundColor(Color.parseColor(colorList.get(i).getC_code()));
                                tv_good.setTextColor(Color.parseColor("#000000"));
                            } else {
                                ConstraintLayout cst = findViewById(R.id.iv_worst);
                                cst.setBackgroundColor(Color.parseColor(colorList.get(i).getC_code()));
                                tv_worst.setTextColor(Color.parseColor("#000000"));
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<PColorDTO>> call, Throwable t) {
                    Log.d("fail_Log", t.getMessage());
                }
            });
        }
    }

    private void setSizeList(){
        HashMap<String, String> params = new HashMap<>();
        params.put("p_code", p_code);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null) {
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getSizeList(params).enqueue(new Callback<ArrayList<PSizeDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PSizeDTO>> call, Response<ArrayList<PSizeDTO>> response) {
                    sizeList = response.body();

                    TableLayout tl_size = (TableLayout)findViewById(R.id.tl_size);
                    TableRow[] tr_size = new TableRow[2];
                    TextView[] td_size = new TextView[sizeList.size()];

                    tr_size[0] = new TableRow(productPage.this);
                    for(int s = 0 ; s < td_size.length; s++){
                        td_size[s] = new TextView(productPage.this);
                        td_size[s] = setDesign(td_size[s], sizeList.get(s).getSize_desc());
                        tr_size[0].addView(td_size[s]);
                    }
                    tl_size.addView(tr_size[0]);

                    tr_size[1] = new TableRow(productPage.this);
                    for(int s = 0 ; s < td_size.length; s++){
                        td_size[s] = new TextView(productPage.this);
                        td_size[s] = setDesign(td_size[s], sizeList.get(s).getSize_part());
                        if(s == 0){
                            td_size[s].setText(sizeList.get(s).getSize_name());
                        }
                        tr_size[1].addView(td_size[s]);
                    }
                    tl_size.addView(tr_size[1]);

                    ChipGroup size_group = (ChipGroup)findViewById(R.id.size_group);
                    for(int i = 0;i < sizeList.size(); i++){
                        if(sizeList.get(i).getSize_seq().equals("0")){
                            PSizeDTO sizeDTO = sizeList.get(i+4);

                            Chip sizeChip = new Chip(productPage.this);
                            sizeChip = setSizeChip(sizeChip, sizeDTO);
                            size_group.addView(sizeChip);
                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<PSizeDTO>> call, Throwable t) {

                }
            });
        }
    }

    private void setBasket(int color, int size, int cnt){
        BasketDTO basketDTO = new BasketDTO(p_code, cnt, m_email, color, size);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.setBasket(basketDTO).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    AlertDialog.Builder dig = new AlertDialog.Builder(productPage.this);
                    dig.setTitle("장바구니 저장");
                    dig.setMessage("장바구니에 저장하였습니다. \n장바구니로 이동하시겠습니까?");
                    dig.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(productPage.this, basketPage.class);
                            startActivity(intent);
                        }
                    });
                    dig.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            onBackPressed();
                        }
                    });
                    dig.show();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
    }


    /*
     * 옵션세팅
     * setColorChip() - 색상
     * setSizeChip() - 사이즈
     */
    private Chip setColorChip(Chip color, PColorDTO dto){
        color.setText(dto.getColor_name());
        color.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor(dto.getC_code())));
        color.setId(Integer.parseInt(dto.getColor_seq()));
        color.setCheckable(true);
        color.setTextSize((float)13);
        color.setGravity(View.TEXT_ALIGNMENT_CENTER);
        return color;
    }
    private Chip setSizeChip(Chip size, PSizeDTO dto){
        size.setText(dto.getSize_name());
        size.setId(Integer.parseInt(dto.getSize_seq()));
        size.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        size.setChipStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        size.setChipStrokeWidth((float)3);
        size.setCheckable(true);
        size.setTextSize((float)13);
        size.setGravity(View.TEXT_ALIGNMENT_CENTER);
        return size;
    }
    private TextView setDesign(TextView tv, String text){
        TableRow.LayoutParams param = new TableRow.LayoutParams( TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f );
        param.setMargins(2,2,2,2);
        tv.setLayoutParams(param);
        tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tv.setPadding(5,5,5,5);
        tv.setGravity(Gravity.CENTER);
        tv.setText(text);
        return tv;
    }
}