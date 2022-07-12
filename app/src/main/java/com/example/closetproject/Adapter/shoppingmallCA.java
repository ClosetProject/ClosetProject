package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.closetproject.DTO.shoppingmallVO;
import com.example.closetproject.R;

import java.util.ArrayList;

public class shoppingmallCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<shoppingmallVO> data;
    private LayoutInflater inflater;

    public shoppingmallCA(Context context, int layout, ArrayList<shoppingmallVO> data){
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

        TextView s_sho_name = view.findViewById(R.id.s_sho_name);
        TextView p_sho_name = view.findViewById(R.id.p_sho_name);
        TextView p_sho_price = view.findViewById(R.id.p_sho_price);
        ImageView p_sho_img = view.findViewById(R.id.p_sho_img);
        CardView sho_card = view.findViewById(R.id.sho_card);
        // LinearLayout linear = view.findViewById(R.id.linear);

        p_sho_img.setImageResource(data.get(i).getImg());
        p_sho_name.setText(data.get(i).getP_name());
        s_sho_name.setText(data.get(i).getS_name());
        p_sho_price.setText(data.get(i).getPrice());


        return view;

    }
}
