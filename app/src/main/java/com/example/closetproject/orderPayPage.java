package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import kr.co.bootpay.Bootpay;
import kr.co.bootpay.BootpayAnalytics;


public class orderPayPage extends AppCompatActivity {

    private int stuck = 10;

//    Dialog orderpay_dialog;
//    TextView parcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay_page);

        BootpayAnalytics.init(this, "[62ccbbd2e38c3000235af6e2]");
    }

    public void onClick_request(View view){
        // 결제 호출
        //Bootuser bootuser = new Bootuser().setPhone("010-1234-5678");

//        orderpay_dialog = new Dialog(orderPayPage.this);
//        orderpay_dialog.getWindow().setGravity(Gravity.BOTTOM);
//        orderpay_dialog.setContentView(R.layout.activity_orderpay_pay_dialog);
//
//
//        findViewById(R.id.parcel).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                orderpay_dialog.show();
//                showDialog01();
//            }
//        });
//    }
//
//    public void showDialog01(){
//        orderpay_dialog.show();
//        TextView tv6 = orderpay_dialog.findViewById(R.id.tv6);
//        tv6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                parcel.setText("(CharSequence) tv6");
//                finish();
//            }
//        });
    }
}
