package com.example.closetproject.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.closetproject.Adapter.mainCA;
import com.example.closetproject.Adapter.storeProductCA;
import com.example.closetproject.DTO.DiagnosisDTO;
import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.OneStoreActivity;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.productPage;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainPage extends Fragment {

    TextView searchView, btn_pop;
    ListView listView;

    ImageView basket_main, com_i_img, com_o_img, com_r_img,com_t_img, com_y_img, com_w_img,
              string_color, summer_color, autumn_color, winter_color;
    ConstraintLayout cst_KNIT0030, cst_KNIT0209, cst_KNIT0031, cst_OPS0008;
    ImageView hart_KNIT0030, hart_KNIT0209, hart_KNIT0031, hart_OPS0008;
    GridView main_grid;
    ArrayList<ProductDTO> productList;
    private RetrofitInterface retrofitAPI;
    private String m_email, d_season;
    Cursor iCursor;
    MemberDTO memberDTO;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getLayoutInflater().inflate((R.layout.fragment_main_page), null);

        basket_main = view.findViewById(R.id.basket_main);
        com_i_img = (ImageView)view.findViewById(R.id.com_i_img);
        com_o_img = (ImageView)view.findViewById(R.id.com_o_img);
        com_r_img = (ImageView)view.findViewById(R.id.com_r_img);
        com_t_img = (ImageView)view.findViewById(R.id.com_t_img);
        com_y_img = (ImageView)view.findViewById(R.id.com_y_img);
        com_w_img = (ImageView)view.findViewById(R.id.com_w_img);
        string_color = (ImageView)view.findViewById(R.id.string_color);
        summer_color = (ImageView)view.findViewById(R.id.summer_color);
        autumn_color = (ImageView)view.findViewById(R.id.autumn_color);
        winter_color = (ImageView)view.findViewById(R.id.winter_color);
        btn_pop = view.findViewById(R.id.btn_pop);

        cst_KNIT0030 = view.findViewById(R.id.cst_KNIT0030);
        cst_KNIT0209 = view.findViewById(R.id.cst_KNIT0209);
        cst_KNIT0031 = view.findViewById(R.id.cst_KNIT0031);
        cst_OPS0008 = view.findViewById(R.id.cst_OPS0008);
        hart_KNIT0030 = view.findViewById(R.id.hart_KNIT0030);
        hart_KNIT0209 = view.findViewById(R.id.hart_KNIT0209);
        hart_KNIT0031 = view.findViewById(R.id.hart_KNIT0031);
        hart_OPS0008 = view.findViewById(R.id.hart_OPS0008);

        m_email = GlobalVariate.getInstance().getM_email();
        d_season = GlobalVariate.getInstance().getD_season();

        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = "";
                String desc = "";
                switch (d_season.substring(0,2)){
                    case "SW":
                        title = getString(R.string.spring_title);
                        desc = getString(R.string.spring);
                        string_color.setImageResource(R.drawable.spring_w1);
                        summer_color.setImageResource(R.drawable.spring_w2);
                        autumn_color.setImageResource(R.drawable.spring_w3);
                        winter_color.setImageResource(R.drawable.spring_w4);
                        break;
                    case "SC":
                        title = getString(R.string.summer_title);
                        desc = getString(R.string.summer);
                        string_color.setImageResource(R.drawable.summer_c1);
                        summer_color.setImageResource(R.drawable.summer_c2);
                        autumn_color.setImageResource(R.drawable.summer_c3);
                        winter_color.setImageResource(R.drawable.summer_c4);
                        break;
                    case "AW":
                        title = getString(R.string.autumn_title);
                        desc = getString(R.string.autumn);
                        string_color.setImageResource(R.drawable.aw1);
                        summer_color.setImageResource(R.drawable.aw2);
                        autumn_color.setImageResource(R.drawable.aw3);
                        winter_color.setImageResource(R.drawable.aw4);
                        break;
                    case "WC":
                        title = getString(R.string.winter_title);
                        desc = getString(R.string.winter);
                        string_color.setImageResource(R.drawable.wc1);
                        summer_color.setImageResource(R.drawable.wc2);
                        autumn_color.setImageResource(R.drawable.wc3);
                        winter_color.setImageResource(R.drawable.wc4);
                        break;
                }

                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
                dlg.setTitle(title); //제목
                dlg.setMessage(desc); // 메세지
                dlg.setPositiveButton("X", null);
                dlg.show();
            }
        });

        basket_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (Intent) new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.basketPage"));
                startActivity(intent);
            }
        });


        // 유튜브 링크 적용
        final ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.youtube.com/watch?v=H9vAfkUyF4Q="+getActivity().getPackageName()));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent weblntent = new Intent(Intent.ACTION_VIEW);
                    weblntent.setData(Uri.parse("http://www.youtube.com/watch?v=H9vAfkUyF4Q="+getActivity().getPackageName()));
                    if (weblntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(weblntent);
                    }
                }

            }
        });

        final ImageView imageView1 = (ImageView)view.findViewById(R.id.img2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=D9Id0nd8TW4Q="+getActivity().getPackageName()));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent weblntent = new Intent(Intent.ACTION_VIEW);
                    weblntent.setData(Uri.parse("https://www.youtube.com/watch?v=D9Id0nd8TW4="+getActivity().getPackageName()));
                    if (weblntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(weblntent);
                    }
                }

            }
        });

        final ImageView imageView2 = (ImageView)view.findViewById(R.id.you_img1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=1bR0Ot40kdc="+getActivity().getPackageName()));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Intent weblntent = new Intent(Intent.ACTION_VIEW);
                    weblntent.setData(Uri.parse("https://www.youtube.com/watch?v=1bR0Ot40kdc="+getActivity().getPackageName()));
                    if (weblntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(weblntent);
                    }
                }

            }
        });

        com_i_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product_intent = new Intent(getContext(), productPage.class);
                product_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                product_intent.setComponent(new ComponentName("com.example.closetproject","com.example.closetproject.productPage"));
                startActivity(product_intent);
            }
        });

        setSeason();
        return view;
    }

    private void setSeason(){
        HashMap<String, String> param = new HashMap<>();
        param.put("m_email", m_email);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getAnalysis(param).enqueue(new Callback<DiagnosisDTO>() {
                @Override
                public void onResponse(Call<DiagnosisDTO> call, Response<DiagnosisDTO> response) {
                    d_season = response.body().getD_result();

                    switch(d_season.substring(0,2)){
                        case "SW":
                            btn_pop.setText("봄 웜 \uD83C\uDF38");
                            break;
                        case "SC":
                            btn_pop.setText("여름 쿨 \uD83C\uDF49");
                            break;
                        case "AW":
                            btn_pop.setText("가을 웜 \uD83C\uDF41");
                            break;
                        case "WC":
                            btn_pop.setText("겨울 쿨 ⛄");
                            break;
                        default:
                            break;
                    }
                }

                @Override
                public void onFailure(Call<DiagnosisDTO> call, Throwable t) {
                    Log.d("fail_Log", t.getMessage());
                }
            });
        }
    }
}