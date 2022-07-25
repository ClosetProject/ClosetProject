package com.example.closetproject.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.BasketDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.R;
import com.example.closetproject.DTO.basketVO;
import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;
import com.example.closetproject.orderPayPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class basketCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<BasketDTO> data;
    private LayoutInflater inflater;
    private RetrofitInterface retrofitAPI;
    String m_email;

    public basketCA(Context context, int layout, ArrayList<BasketDTO> data){
        this.context = context;
        this.layout = layout;
        this.data = data;
        m_email = GlobalVariate.getInstance().getM_email();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(layout,null);

        ImageView p_img = view.findViewById(R.id.p_img);
        TextView s_name = view.findViewById(R.id.s_name);
        TextView p_name = view.findViewById(R.id.p_name);
        TextView p_point = view.findViewById(R.id.p_point);
        TextView p_price = view.findViewById(R.id.p_price);
        Spinner p_cnt = view.findViewById(R.id.p_cnt);
        ImageView iv_close = view.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> params = new HashMap<>();
                params.put("m_email", m_email);
                params.put("p_code", data.get(i).getP_code());

                retrofitAPI = RetrofitClient.getRetrofitAPI();
                retrofitAPI.delBasket(params).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Intent intent = ((Activity)context).getIntent();
                        ((Activity)context).finish(); //현재 액티비티 종료 실시
                        ((Activity)context).overridePendingTransition(0, 0); //효과 없애기
                        ((Activity)context).startActivity(intent); //현재 액티비티 재실행 실시
                        ((Activity)context).overridePendingTransition(0, 0); //효과 없애기
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });

        //ImageView close = view.findViewById(R.id.close);

        s_name.setText("[" + data.get(i).getS_name() + "]");
        p_name.setText(data.get(i).getP_name());
        p_point.setText(data.get(i).getColor_name() + "/" + data.get(i).getSize_name());
        p_price.setText(data.get(i).getP_price() + "원");
        String cnt = data.get(i).toString();
        p_cnt.setTooltipText((CharSequence)cnt);
        String img_path = GlobalVariate.getInstance().getBaseURL() + data.get(i).getP_img() + data.get(i).getColor_name() + ".jpg";

        Glide.with(context)
                .load(img_path)
                .error(R.drawable.noimg)
                .into(p_img);

        return view;
    }
}
