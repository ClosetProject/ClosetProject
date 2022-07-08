package com.example.closetproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class orderpay_dailog_list_CA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<orderpay_dailog_list_VO> data;
    private LayoutInflater inflater;

    public orderpay_dailog_list_CA(Context context, int layout, ArrayList<orderpay_dailog_list_VO> data){
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {return data.size();}

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

        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);
        TextView tv3 = view.findViewById(R.id.tv3);
        TextView tv4 = view.findViewById(R.id.tv4);
        TextView tv5 = view.findViewById(R.id.tv5);

        tv1.setText(data.get(i).getTv1());
        tv2.setText(data.get(i).getTv2());
        tv3.setText(data.get(i).getTv3());
        tv4.setText(data.get(i).getTv4());
        tv5.setText(data.get(i).getTv5());

        return view;

    }
}
