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

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.BasketDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.R;
import com.example.closetproject.DTO.basketVO;

import java.util.ArrayList;

public class basketCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<BasketDTO> data;
    private LayoutInflater inflater;

    public basketCA(Context context, int layout, ArrayList<BasketDTO> data){
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

        ImageView p_img = view.findViewById(R.id.p_img);
        TextView s_name = view.findViewById(R.id.s_name);
        TextView p_name = view.findViewById(R.id.p_name);
        TextView p_point = view.findViewById(R.id.p_point);
        TextView p_price = view.findViewById(R.id.p_price);
        Spinner p_cnt = view.findViewById(R.id.p_cnt);

        //ImageView close = view.findViewById(R.id.close);

        s_name.setText("[" + data.get(i).getS_name() + "]");
        p_name.setText(data.get(i).getP_name());
        p_point.setText(data.get(i).getColor_name() + "/" + data.get(i).getSize_name());
        p_price.setText(data.get(i).getP_price() + "원");
        String cnt = data.get(i).toString();
        p_cnt.setTooltipText((CharSequence)cnt);
        String img_path = GlobalVariate.getInstance().getBaseURL() + data.get(i).getP_img() + "/" + data.get(i).getColor_name() + ".jpg";

        Glide.with(context)
                .load(img_path)
                .error(R.drawable.noimg)
                .into(p_img);

        return view;
    }
}
