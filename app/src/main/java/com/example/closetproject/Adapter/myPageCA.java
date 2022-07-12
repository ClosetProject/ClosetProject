package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.closetproject.R;
import com.example.closetproject.DTO.myPageVO;

import java.util.ArrayList;

public class myPageCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<myPageVO> data;
    private LayoutInflater inflater;

    public myPageCA(Context context, int layout, ArrayList<myPageVO> data) {
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

        TextView p_my_name = view.findViewById(R.id.s_sho_name);
        TextView s_my_name = view.findViewById(R.id.p_sho_name);
        TextView p_my_price = view.findViewById(R.id.p_sho_price);
        ImageView p_my_img = view.findViewById(R.id.p_sho_img);
        CardView my_card = view.findViewById(R.id.sho_card);
       // LinearLayout linear = view.findViewById(R.id.linear);

        p_my_img.setImageResource(data.get(i).getImg());
        p_my_name.setText(data.get(i).getP_name());
        s_my_name.setText(data.get(i).getS_name());
        p_my_price.setText(data.get(i).getPrice());


        return view;
    }
}
