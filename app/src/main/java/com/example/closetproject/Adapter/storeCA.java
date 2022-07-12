package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.closetproject.DTO.StoreDTO;
import com.example.closetproject.R;

import java.util.ArrayList;

public class storeCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<StoreDTO> data;
    private LayoutInflater inflater;

    private TextView catv_s_seq, catv_s_name,catv_s_desc;
    private ImageView caiv_s_img;

    public storeCA(Context context, int layout, ArrayList<StoreDTO> data) {
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

        catv_s_seq = view.findViewById(R.id.catv_s_seq);
        catv_s_name = view.findViewById(R.id.catv_s_name);
        catv_s_desc = view.findViewById(R.id.catv_s_desc);
        caiv_s_img = view.findViewById(R.id.caiv_s_img);

        catv_s_seq.setText(data.get(i).getS_seq());
        catv_s_name.setText(data.get(i).getS_name());
        catv_s_desc.setText(data.get(i).getS_desc());

        return view;
    }
}
