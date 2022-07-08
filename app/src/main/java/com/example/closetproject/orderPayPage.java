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

public class orderPayPage extends AppCompatActivity {

    Dialog orderpay_dialog;
    TextView parcel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay_page);

        orderpay_dialog = new Dialog(orderPayPage.this);
        orderpay_dialog.getWindow().setGravity(Gravity.BOTTOM);
        orderpay_dialog.setContentView(R.layout.activity_orderpay_pay_dialog);


        findViewById(R.id.parcel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                orderpay_dialog.show();
                showDialog01();
            }
        });
    }

    public void showDialog01(){
        orderpay_dialog.show();
        TextView tv6 = orderpay_dialog.findViewById(R.id.tv6);
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                parcel.setText("(CharSequence) tv6");
                finish();
            }
        });
    }
}
