package com.example.closetproject.Fragment;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.closetproject.Adapter.mainCA;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.DTO.mainVO;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.ParamsVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.productPage;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainPage extends Fragment {

    TextView searchView;
    ListView listView;
    ImageView basket_main, com_i_img, com_o_img, com_r_img,com_t_img, com_y_img, com_w_img ;
    GridView main_grid;
    ArrayList<ProductDTO> productList;
    private RetrofitInterface retrofitAPI;

    mainCA adapter;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;

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
        //main_grid = view.findViewById(R.id.main_grid);

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

        return view;

    }



}