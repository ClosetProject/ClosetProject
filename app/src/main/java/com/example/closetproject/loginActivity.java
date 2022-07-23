package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginActivity extends AppCompatActivity {

    private LinearLayout dialogView;
    private EditText edit_loginemail, edit_loginpw;
    private TextView tv_join;
    private Button btn_login;

    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 자동 로그인 정보가 있을경우 바로 메인 페이지로 이동
        SharedPreferences auto = getSharedPreferences("autoLogin", Activity.MODE_PRIVATE);
        String mEmail = auto.getString("m_email", null);
        String mPW = auto.getString("m_pw", null);
        String mSeason = auto.getString("m_season", null);
        if(mEmail != null && mPW != null){
            GlobalVariate.getInstance().setM_email(mEmail);
            GlobalVariate.getInstance().setD_season(mSeason);
            Intent intent = new Intent(loginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        edit_loginemail = findViewById(R.id.edit_loginemail);
        edit_loginpw = findViewById(R.id.edit_loginpw);
        btn_login = findViewById(R.id.btn_login);
        tv_join = findViewById(R.id.tv_join);
        tv_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(loginActivity.this,JoinActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login_email = edit_loginemail.getText().toString();
                String login_pw = edit_loginpw.getText().toString();

                HashMap<String, String> params = new HashMap<>();
                params.put("m_email", login_email);
                params.put("m_pw", login_pw);
                RetrofitClient retrofitClient = RetrofitClient.getInstance();

                if (retrofitClient != null){
                    retrofitAPI = RetrofitClient.getRetrofitAPI();
                    retrofitAPI.getMember(params).enqueue(new Callback<MemberDTO>() {
                        @Override
                        public void onResponse(Call<MemberDTO> call, Response<MemberDTO> response) {
                            if(response.isSuccessful()) {
                                MemberDTO memberDTO = response.body();
                                GlobalVariate.getInstance().setM_email(login_email);
                                GlobalVariate.getInstance().setD_season(memberDTO.getD_season());

                                CheckBox chk_autoLogin = findViewById(R.id.chk_autoLogin);
                                // 자동 로그인을 위해 데이터 저장
                                if (chk_autoLogin.isChecked()) {
                                    // 자동 로그인 데이터 저장
                                    SharedPreferences auto = getSharedPreferences("autoLogin", Activity.MODE_PRIVATE);
                                    SharedPreferences.Editor autoLoginEdit = auto.edit();
                                    autoLoginEdit.putString("m_email", memberDTO.getM_email());
                                    autoLoginEdit.putString("m_pw", memberDTO.getM_pw());
                                    autoLoginEdit.putString("m_season", memberDTO.getD_season());
                                    autoLoginEdit.commit();
                                }

                                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                AlertDialog.Builder dig = new AlertDialog.Builder(loginActivity.this);
                                dig.setTitle("로그인 실패");
                                dig.setMessage("로그인에 실패하였습니다.");
                                dig.setPositiveButton("OK",null);
                                dig.show();
                            }
                        }
                        @Override
                        public void onFailure(Call<MemberDTO> call, Throwable t) {
                            Log.d("failure", t.getMessage());
                        }
                    });
                }
            }
        });

    }
}