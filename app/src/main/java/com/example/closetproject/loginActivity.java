package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginActivity extends AppCompatActivity {

    EditText edit_loginemail, edit_loginpw;
    Button btn_login;
    TextView join;
    LinearLayout dialogView;

    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_loginemail = findViewById(R.id.edit_loginemail);
        edit_loginpw = findViewById(R.id.edit_loginpw);
        btn_login = findViewById(R.id.btn_login);
        join = findViewById(R.id.join);


        join.setOnClickListener(new View.OnClickListener() {
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

                String sql = "select * from tbl_member where m_email = :1 and m_pw = :2";
                String[] header = {"m_email", "m_pw","m_name","m_date","m_type"};
                String[] params = {login_email, login_pw};

                ParamsVO paramsVO = new ParamsVO(sql, header, params);
                RetrofitClient retrofitClient = RetrofitClient.getInstance();


                if (retrofitClient != null){
                    retrofitAPI = RetrofitClient.getRetrofitAPI();
                    retrofitAPI.getMember(paramsVO).enqueue(new Callback<MemberDTO>() {
                        @Override
                        public void onResponse(Call<MemberDTO> call, Response<MemberDTO> response) {
                            if(response.isSuccessful()){
                                // (추가)진단페이지로 넘어가도록 추후 수정
                                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                dialogView = (LinearLayout) View.inflate(loginActivity.this, R.layout.login_dialog, null);
                                AlertDialog.Builder dig = new AlertDialog.Builder(loginActivity.this);
                                dig.setTitle("alrt");
                                dig.setView(dialogView);
                                dig.setPositiveButton("OK",null);
                                dig.show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MemberDTO> call, Throwable t) {
                            Log.d("res", t.getMessage());
                        }

                    });
                }
            }
        });

    }
}