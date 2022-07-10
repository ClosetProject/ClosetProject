package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.closetproject.R;
import com.example.closetproject.DTO.storeVO;

import java.util.ArrayList;

public class storeCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<storeVO> data;
    private LayoutInflater inflater;

    public storeCA(Context context, int layout, ArrayList<storeVO> data) {
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

        TextView s_seq = view.findViewById(R.id.s_seq);
        TextView s_store_name = view.findViewById(R.id.s_store_name);
        TextView s_store_concept = view.findViewById(R.id.s_store_concept);
        ImageView s_img = view.findViewById(R.id.s_img);

        s_seq.setText(data.get(i).getSeq());
        s_store_name.setText(data.get(i).getS_name());
        s_store_concept.setText(data.get(i).getConcept());

        return view;
    }
}
