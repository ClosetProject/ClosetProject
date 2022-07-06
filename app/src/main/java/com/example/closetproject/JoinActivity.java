package com.example.closetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinActivity extends AppCompatActivity {

    EditText edit_joinemail, edit_joinpw, edit_joinname;
    Button btn_join;

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
            }
        });
    }
}