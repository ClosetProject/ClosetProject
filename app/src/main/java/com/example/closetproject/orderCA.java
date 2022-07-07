package com.example.closetproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class orderCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<orderVO> data;
    private LayoutInflater inflater;

    public orderCA(Context context, int layout, ArrayList<orderVO> data){
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {return data.size();}

    @Override
    public Object getItem(int i) {return data.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(layout,null);

        TextView order_date = view.findViewById(R.id.order_date);
        TextView order_pay = view.findViewById(R.id.order_pay);
        TextView p_order_price = view.findViewById(R.id.p_order_price);
        TextView s_order_name = view.findViewById(R.id.s_order_name);
        TextView p_order_name = view.findViewById(R.id.p_order_name);
        TextView p_order_color = view.findViewById(R.id.p_order_color);
        TextView p_order_size = view.findViewById(R.id.p_order_size);
        TextView order_text = view.findViewById(R.id.order_text);
        View view4 = view.findViewById(R.id.view4);
        ImageView p_order_img = view.findViewById(R.id.p_order_img);

        order_date.setText(data.get(i).getDate());
        p_order_price.setText(data.get(i).getPrice());
        s_order_name.setText(data.get(i).getS_name());
        p_order_name.setText(data.get(i).getP_name());
        p_order_color.setText(data.get(i).getColor());
        p_order_size.setText(data.get(i).getSize());
        p_order_img.setImageResource(data.get(i).getImg());

        return view;
    }
}
