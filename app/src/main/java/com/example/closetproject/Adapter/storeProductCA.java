package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.R;

import java.util.ArrayList;

public class storeProductCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<ProductDTO> data;
    private LayoutInflater inflater;

    private ImageView caiv_sp_img;
    private TextView catv_sp_price, catv_sp_name;

    public storeProductCA(Context context, int layout, ArrayList<ProductDTO> data){
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

        caiv_sp_img = view.findViewById(R.id.caiv_sp_img);
        catv_sp_price = view.findViewById(R.id.catv_sp_price);
        catv_sp_name = view.findViewById(R.id.catv_sp_name);

        //caiv_sp_img.setText(data.get(i).getP_name());
        catv_sp_price.setText(data.get(i).getP_price());
        catv_sp_name.setText(data.get(i).getP_name());

        return view;

    }
}
