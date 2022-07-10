package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.closetproject.DTO.mainVO;
import com.example.closetproject.R;

import java.util.ArrayList;

public class mainCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<mainVO> data;
    private LayoutInflater inflater;

    public mainCA(Context context, int layout, ArrayList<mainVO> data) {
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
        context = viewGroup.getContext();

        TextView s_main_name = view.findViewById(R.id.s_main_name);
        TextView p_main_name = view.findViewById(R.id.p_my_name);
        TextView p_main_price = view.findViewById(R.id.p_main_price);
        ImageView p_main_img = view.findViewById(R.id.p_main_img);
        ImageView p_main_wish = view.findViewById(R.id.p_main_wish);

        s_main_name.setText(data.get(i).getS_name());
        //p_main_name.setText(data.get(i).getP_name());
        p_main_img.setImageResource(data.get(i).getImg());

        return view;
    }
}
