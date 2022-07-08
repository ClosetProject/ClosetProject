package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.closetproject.Adapter.orderpay_dailog_list_CA;
import com.example.closetproject.DTO.orderpay_dailog_list_VO;

import java.util.ArrayList;

public class orderpay_pay_dialog extends AppCompatActivity {

    ListView orderpay_dailog_lv;
    orderpay_dailog_list_CA adapter;
    ArrayList<orderpay_dailog_list_VO> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderpay_pay_dialog);

//        orderpay_dailog_lv = findViewById(R.id.orderpay_dailog_lv);
//        data = new ArrayList<orderpay_dailog_list_VO>();
//
//        data.add(new orderpay_dailog_list_VO("부재시 경비실에 맡겨주세요.", "집앞에 놔주세요.",
//                "택배함에 놔주세요", "집으로 직접 배송해주세요.", "배송 전에 꼭 연락주세요."));
//
//        adapter = new orderpay_dailog_list_CA(orderpay_pay_dialog.this,R.layout.orderpay_dialog_list,data);
//
//        orderpay_dailog_lv.setAdapter(adapter);
    }
}