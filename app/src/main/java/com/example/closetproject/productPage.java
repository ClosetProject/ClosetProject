package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class productPage extends AppCompatActivity {

    ImageView s_basket3;
    Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        s_basket3 = findViewById(R.id.s_basket3);
        btn_pay = (Button) findViewById(R.id.btn_pay);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.test_dialog_option, null);
        final Spinner spSex = (Spinner) alertLayout.findViewById(R.id.spSex);
        final Spinner spSex2 = (Spinner) alertLayout.findViewById(R.id.spSex2);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("옵션선택");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String sex = String.valueOf(spSex.getSelectedItem());
                String sex1 = String.valueOf(spSex2.getSelectedItem());

                Toast.makeText(getBaseContext(), "color: " + sex + "\nsize: " + sex1, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();

        s_basket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(productPage.this, basketPage.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}