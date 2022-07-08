package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.closetproject.Retrofit_API.RetrofitInterface;

public class loginActivity extends AppCompatActivity {

    EditText edit_loginemail, edit_loginpw;
    Button btn_login;
    TextView join;

    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_loginemail = findViewById(R.id.edit_loginemail);
        edit_loginpw = findViewById(R.id.edit_loginpw);
        btn_login = findViewById(R.id.btn_login);
        join = findViewById(R.id.join);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String login_email = edit_loginemail.getText().toString();
                String login_pw = edit_loginpw.getText().toString();

                String sql = "select m_email, m_pw from tbl_member";
                String[]
            }
        });

    }
}