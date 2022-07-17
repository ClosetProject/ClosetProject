package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {

    EditText edit_joinemail, edit_joinpw, edit_joinname;
    Button btn_join;

    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edit_joinemail = findViewById(R.id.edit_joinemail);
        edit_joinpw = findViewById(R.id.edit_joinpw);
        edit_joinname = findViewById(R.id.edit_joinname);
        btn_join = findViewById(R.id.btn_join);

        // join 버튼 클릭 시
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // email, pw, 이름을 가져온다.
                String m_email = edit_joinemail.getText().toString();
                String m_pw = edit_joinpw.getText().toString();
                String m_name = edit_joinname.getText().toString();

                // (추가)공백 불가, 중복 이메일 체킹 기능 추가

                // insert된 이메일, pw, 이름, 관리자 타입을 추가
                String sql = "insert into tbl_member(m_email, m_pw, m_name, m_type) values (:1, :2, :3, :4)";
                String[] params = {m_email, m_pw, m_name, "N"};

                ParamsVO paramsVO = new ParamsVO(sql, params);
                RetrofitClient retrofitClient = RetrofitClient.getInstance();
                if(retrofitClient != null){
                    retrofitAPI = RetrofitClient.getRetrofitAPI();
                    retrofitAPI.joinMember(paramsVO).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if(response.isSuccessful()){
                                // (추가)진단페이지로 넘어가도록 추후 수정
                                Intent intent = new Intent(JoinActivity.this, AnalysisActivity.class);
                                intent.putExtra("m_email", m_email);
                                startActivity(intent);
                                finish();
                            }else{
                                Log.d("res","실패");
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("res", t.getMessage());
                        }
                    });
                }
            }
        });
    }
}