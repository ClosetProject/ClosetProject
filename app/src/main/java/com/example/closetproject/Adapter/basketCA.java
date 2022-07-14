package com.example.closetproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.example.closetproject.R;
import com.example.closetproject.DTO.basketVO;

import java.util.ArrayList;

public class basketCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<basketVO> data;
    private LayoutInflater inflater;

    public basketCA(Context context, int layout, ArrayList<basketVO> data){
        this.context = context;
        this.layout = layout;
        this.data = data;
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

        TextView prodect = view.findViewById(R.id.prodect);
        ImageView p_img = view.findViewById(R.id.p_img);
        TextView p_name = view.findViewById(R.id.p_name);
        TextView p_point = view.findViewById(R.id.p_point);
        TextView s_name = view.findViewById(R.id.s_name);
        Spinner p_cnt = view.findViewById(R.id.p_cnt);
        TextView p_price = view.findViewById(R.id.p_price);

        ImageView close = view.findViewById(R.id.close);
        ImageView seomo = view.findViewById(R.id.seomo);

        s_name.setText(data.get(i).getS_name());
        p_name.setText(data.get(i).getP_name());
        p_point.setText(data.get(i).getPoint());
        p_price.setText(data.get(i).getPrice());
        p_img.setImageResource(data.get(i).getImg());


        return view;
    }
}
