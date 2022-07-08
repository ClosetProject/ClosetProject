package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String join_email = edit_joinemail.getText().toString();
                String join_pw = edit_joinpw.getText().toString();
                String join_name = edit_joinname.getText().toString();

                String sql = "select * from tbl_member where m_email = :1 and m_pw = :2";
                String[] header = {"m_email", "m_pw", "m_name", "m_date", "m_type"};
                String[] params = {"admin@naver.com", "admin"};

                ParamsVO paramsVO = new ParamsVO(sql, header, params);

                RetrofitClient retrofitClient = RetrofitClient.getInstance();

                if(retrofitClient != null){
                    retrofitAPI = RetrofitClient.getRetrofitAPI();
                    retrofitAPI.getMember(paramsVO).enqueue(new Callback<MemberDTO>() {
                        @Override
                        public void onResponse(Call<MemberDTO> call, Response<MemberDTO> response) {
                            Log.d("res", response.body().getM_type());
                        }

                        @Override
                        public void onFailure(Call<MemberDTO> call, Throwable t) {
                            Log.d("res", "failure");
                        }
                    });
                }

            }
        });
    }
}