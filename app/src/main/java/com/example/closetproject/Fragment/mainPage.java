package com.example.closetproject.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.closetproject.Adapter.mainCA;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.productPage;

import java.util.ArrayList;

public class mainPage extends Fragment {

    TextView searchView;
    ListView listView;
    ImageView basket_main, com_i_img, com_o_img, com_r_img,com_t_img, com_y_img, com_w_img ;
    GridView main_grid;
    ArrayList<ProductDTO> productList;
    private RetrofitInterface retrofitAPI;


    mainCA adapter;
    String[] s_name = {"커먼유니크", "육육걸즈", "언니날다", "블랙업", "메롱샵", "입어보고"};
    String[] p_name = {"흰색블라우스", "공주님옷", "샤랄라라", "힙해요", "메롱메롱", "체크무늬크롭"};
    int[] img = {R.drawable.com_i_1, R.drawable.com_o_1, R.drawable.com_r_1, R.drawable.com_t_1, R.drawable.com_y_1, R.drawable.com_w_1};
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


        Button btn_pop = view.findViewById(R.id.btn_pop);
        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
                dlg.setTitle("봄 웜\uD83C\uDF38"); //제목
                dlg.setMessage("- 밝고 생기있고 사랑스러운 동안 인상\n" +
                        "- 투명하고 복숭아 빛의 피부\n" +
                        "- 밝은 파스텔톤이나 비비드 컬러가 잘어울리는편\n" +
                        "- 대표 연예인 : 수지, 아이유, 윤아, 송혜교 등"); // 메세지
                dlg.setPositiveButton("X", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 토스트 메세지
                        Toast.makeText(getContext(), "마이페이지에서 재진단 가능",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
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


    // grid 화면 적용
//    private void setProductAdapter() {
//
//        // 데이터 불러오기
//        String sql = "SELECT A.P_CODE, A.P_NAME, A.P_IMG, A.P_CAT, A.P_PRICE, A.S_SEQ, B.S_NAME FROM TBL_PRODUCT A, TBL_STORE B WHERE B.S_SEQ = A.S_SEQ AND ROWNUM < 7";
//        String[] header = {"P_CODE", "P_NAME", "P_IMG", "P_CAT", "P_PRICE", "S_SEQ", "S_NAME"};
//        String[] params = {"null"};
//
//        ParamsVO paramsVO = new ParamsVO(sql, header, params);
//        RetrofitClient retrofitClient = RetrofitClient.getInstance();
//
//        if (retrofitClient != null) {
//
//            retrofitAPI = RetrofitClient.getRetrofitAPI();
//            retrofitAPI.getProductAdapter(paramsVO).enqueue(new Callback<ArrayList<ProductDTO>>() {
//
//                @Override
//                public void onResponse(Call<ArrayList<ProductDTO>> call, Response<ArrayList<ProductDTO>> response) {
//                    if (response.isSuccessful()) {
//                        productList = response.body();
//                        adapter = new mainCA(getActivity(), R.layout.fragment_main_list, productList);
//                        // main_grid.setAdapter(adapter);
//
//                    } else {
//                        Log.d("failure", "불러올 제품이 없습니다");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ArrayList<ProductDTO>> call, Throwable t) {
//                    Log.d("failure", t.getMessage());
//
//                }
//            });
//        }
//    }
}