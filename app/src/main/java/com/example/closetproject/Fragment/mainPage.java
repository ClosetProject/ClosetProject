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
import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.R;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.productPage;

import java.util.ArrayList;
import java.util.HashMap;

public class mainPage extends Fragment {

    TextView searchView;
    ListView listView;
    ImageView basket_main, com_i_img, com_o_img, com_r_img,com_t_img, com_y_img, com_w_img,
              string_color, summer_color, autumn_color, winter_color;
    GridView main_grid;
    ArrayList<ProductDTO> productList;
    private RetrofitInterface retrofitAPI;
    private String m_email, d_season;
    Cursor iCursor;
    MemberDTO memberDTO;


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
        string_color = (ImageView)view.findViewById(R.id.string_color);
        summer_color = (ImageView)view.findViewById(R.id.summer_color);
        autumn_color = (ImageView)view.findViewById(R.id.autumn_color);
        winter_color = (ImageView)view.findViewById(R.id.winter_color);
        Button btn_pop = view.findViewById(R.id.btn_pop);


//        m_email = GlobalVariate.getInstance().getM_email();
//        d_season = GlobalVariate.getInstance().getD_season();
//
//        if (d_season.contains("SW")) {
//            string_color.setImageResource(R.drawable.spring_w1);
//            string_color.setImageResource(R.drawable.spring_w2);
//            string_color.setImageResource(R.drawable.spring_w3);
//            string_color.setImageResource(R.drawable.spring_w4);
//
//            btn_pop.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
//                    dlg.setTitle("봄 웜\uD83C\uDF38"); //제목
//                    dlg.setMessage("- 밝고 생기있고 사랑스러운 동안 인상\n" +
//                            "- 투명하고 복숭아 빛의 피부\n" +
//                            "- 밝은 파스텔톤이나 비비드 컬러가 잘어울리는편\n" +
//                            "- 대표 연예인 : 수지, 아이유, 윤아, 송혜교 등"); // 메세지
//                    dlg.setPositiveButton("X", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            // 토스트 메세지
//                            Toast.makeText(getContext(), "마이페이지에서 재진단 가능",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    dlg.show();
//                }
//            });
//
//        }else if (d_season.equals("SCL")&&d_season.equals("SCB")){
//            string_color.setImageResource(R.drawable.spring_w1);
//            string_color.setImageResource(R.drawable.spring_w2);
//            string_color.setImageResource(R.drawable.spring_w3);
//            string_color.setImageResource(R.drawable.spring_w4);
//
//            btn_pop.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
//                    dlg.setTitle("여름 쿨\uD83C\uDF49"); //제목
//                    dlg.setMessage("- 시원하고 깨끗하며 지적이고 우아한 인상\n" +
//                            "        - 밝고 투명하면서도 붉은 기가 감도는 피부\n" +
//                            "        - 맑고 가벼운 메이크업이 잘어울리는편\n" +
//                            "        - 대표 연예인 : 장원영, 이영애, 태연, 김연아 등"); // 메세지
//                    dlg.setPositiveButton("X", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            // 토스트 메세지
//                            Toast.makeText(getContext(), "마이페이지에서 재진단 가능",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    dlg.show();
//                }
//            });
//
//        }else if (d_season.equals("AWM")&&d_season.equals("AWD")){
//            string_color.setImageResource(R.drawable.spring_w1);
//            string_color.setImageResource(R.drawable.spring_w2);
//            string_color.setImageResource(R.drawable.spring_w3);
//            string_color.setImageResource(R.drawable.spring_w4);
//
//            btn_pop.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
//                    dlg.setTitle("가을 웜\uD83C\uDF41"); //제목
//                    dlg.setMessage("- 성숙하면서 섹시하고 분위기있는 인상\n" +
//                            "        - 누르스름한 피부톤에 혈색이 있으며 매끈매끈하며 탄력이 있는 피부를 가짐\n" +
//                            "        - 과한 음영과 그라데이션이 잘어울리는편\n" +
//                            "        - 대표 연예인 : 제니, 이효리, 신세경, 전지현 등"); // 메세지
//                    dlg.setPositiveButton("X", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            // 토스트 메세지
//                            Toast.makeText(getContext(), "마이페이지에서 재진단 가능",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    dlg.show();
//                }
//            });
//
//        }else {
//            string_color.setImageResource(R.drawable.spring_w1);
//            string_color.setImageResource(R.drawable.spring_w2);
//            string_color.setImageResource(R.drawable.spring_w3);
//            string_color.setImageResource(R.drawable.spring_w4);
//
//            btn_pop.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
//                    dlg.setTitle("겨울 쿨⛄"); //제목
//                    dlg.setMessage("- 현대적이고 세련되고 도도한 인상\n" +
//                            "        - 홍조가 없는 새하얀 피부\n" +
//                            "        - 푸른색과 검은색을 바탕으로 한 차갑고 채도가 높은 컬러가 잘어울리는편\n" +
//                            "        - 대표 연예인 : 현아, 선미, 김혜수, 이나영 등"); // 메세지
//                    dlg.setPositiveButton("X", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            // 토스트 메세지
//                            Toast.makeText(getContext(), "마이페이지에서 재진단 가능",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    dlg.show();
//                }
//            });
//
//        }

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