package com.example.closetproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import kr.co.bootpay.Bootpay;
import kr.co.bootpay.BootpayAnalytics;
import kr.co.bootpay.enums.Method;
import kr.co.bootpay.enums.PG;
import kr.co.bootpay.enums.UX;
import kr.co.bootpay.listener.CancelListener;
import kr.co.bootpay.listener.CloseListener;
import kr.co.bootpay.listener.ConfirmListener;
import kr.co.bootpay.listener.DoneListener;
import kr.co.bootpay.listener.ReadyListener;
import kr.co.bootpay.model.BootExtra;
import kr.co.bootpay.model.BootUser;


public class orderPayPage extends AppCompatActivity {

    private int stuck = 10;
    ImageView order_pay_next;
    Button btn_pay1;

//    Dialog orderpay_dialog;
//    TextView parcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay_page);

        BootpayAnalytics.init(this, "62ccbbd2e38c3000235af6e2");

        btn_pay1 = findViewById(R.id.btn_pay1);
        btn_pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BootUser bootUser = new BootUser().setPhone("010-1234-5678"); // !! 자신의 핸드폰 번호로 바꾸기
                BootExtra bootExtra = new BootExtra().setQuotas(new int[] {0, 2, 3});

                Bootpay.init(getFragmentManager())
                        .setApplicationId("62ccbbd2e38c3000235af6e2") // 해당 프로젝트(안드로이드)의 application id 값(위의 값 복붙)
                        .setPG(PG.INICIS) // 결제할 PG 사
                        .setMethod(Method.CARD) // 결제수단
                        .setContext(orderPayPage.this)
                        .setBootUser(bootUser)
                        .setBootExtra(bootExtra)
                        .setUX(UX.PG_DIALOG)
//                .setUserPhone("010-1234-5678") // 구매자 전화번호
                        .setName("맥북프로's 임다") // 결제할 상품명
                        .setOrderId("1234") // 결제 고유번호 (expire_month)
                        .setPrice(10000) // 결제할 금액
                        .addItem("마우's 스", 1, "ITEM_CODE_MOUSE", 100) // 주문정보에 담길 상품정보, 통계를 위해 사용
                        .addItem("키보드", 1, "ITEM_CODE_KEYBOARD", 200, "패션", "여성상의", "블라우스") // 주문정보에 담길 상품정보, 통계를 위해 사용
                        .onConfirm(new ConfirmListener() { // 결제가 진행되기 바로 직전 호출되는 함수로, 주로 재고처리 등의 로직이 수행
                            @Override
                            public void onConfirm(@Nullable String message) {

                                if (0 < stuck) Bootpay.confirm(message); // 재고가 있을 경우.
                                else Bootpay.removePaymentWindow(); // 재고가 없어 중간에 결제창을 닫고 싶을 경우
                                Log.d("confirm", message);
                            }
                        })
                        .onDone(new DoneListener() { // 결제완료시 호출, 아이템 지급 등 데이터 동기화 로직을 수행합니다
                            @Override
                            public void onDone(@Nullable String message) {
                                Log.d("done", message);
                            }
                        })
                        .onReady(new ReadyListener() { // 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
                            @Override
                            public void onReady(@Nullable String message) {
                                Log.d("ready", message);
                            }
                        })
                        .onCancel(new CancelListener() { // 결제 취소시 호출
                            @Override
                            public void onCancel(@Nullable String message) {

                                Log.d("cancel", message);
                            }
                        })
                        .onClose(
                                new CloseListener() { //결제창이 닫힐때 실행되는 부분
                                    @Override
                                    public void onClose(String message) {
                                        Log.d("close", "close");
                                    }
                                })
                        .request();

            }
        });

        order_pay_next = findViewById(R.id.order_pay_next);

        order_pay_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orderPayPage.this, basketPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
            }
        });

        order_pay_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orderPayPage.this, productPage.class);
                startActivity(intent);
                finish();
            }
        });

        // 결제방식 선택 버튼
        Button btn_card = findViewById(R.id.btn_card);
        Button btn_kakao = findViewById(R.id.btn_kakao);
        Button btn_m = findViewById(R.id.btn_m);

        // 카드
        btn_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_card.setBackgroundColor(getApplication().getResources().getColor(R.color.gray));
                btn_card.setTextColor(getApplication().getResources().getColor(R.color.white));
            }
        });

        // 카카오페이
        btn_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_kakao.setBackgroundColor(getApplication().getResources().getColor(R.color.gray));
                btn_kakao.setTextColor(getApplication().getResources().getColor(R.color.white));
            }
        });

        // 가상화폐
        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_m.setBackgroundColor(getApplication().getResources().getColor(R.color.gray));
                btn_m.setTextColor(getApplication().getResources().getColor(R.color.white));
            }
        });





        // 결제버튼 누르기
        btn_pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(orderPayPage.this, payment.class);
                startActivity(intent6);
            }
        });
    }

}
