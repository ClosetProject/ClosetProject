package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.closetproject.R;
import com.example.closetproject.DTO.orderVO;

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
        ImageView p_order_img = view.findViewById(R.id.p_order_img);

        order_date.setText(data.get(i).getDate());
        p_order_price.setText(data.get(i).getPrice());
        s_order_name.setText(data.get(i).getS_name());
        p_order_name.setText(data.get(i).getP_name());
        p_order_color.setText(data.get(i).getColor());
        p_order_size.setText(data.get(i).getSize());
        //p_order_img.setImageResource(data.get(i).getImg());
        String img_path = "http://121.147.185.76:8081/static/product_image/OPS/OPS0021/WHITE.jpg";
        Glide.with(context)
                .load(img_path)
                .error(R.drawable.noimg)
                .into(p_order_img);

        return view;
    }
}
