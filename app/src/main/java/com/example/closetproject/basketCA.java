package com.example.closetproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class basketCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<basketVO> data;
    private LayoutInflater inflater;

    public basketCA(Context context, int layout, ArrayList<basketVO> data){
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

        TextView prodect = view.findViewById(R.id.prodect);
        ImageView p_img = view.findViewById(R.id.p_img);
        TextView p_name = view.findViewById(R.id.p_name);
        TextView p_point = view.findViewById(R.id.p_point);
        TextView s_name = view.findViewById(R.id.s_name);
        Button p_change = view.findViewById(R.id.p_change);
        CheckBox check = view.findViewById(R.id.check);
        Button p_cnt = view.findViewById(R.id.p_cnt);
        TextView p_price = view.findViewById(R.id.p_price);
        View finish_lin = view.findViewById(R.id.finish_lin);

        s_name.setText(data.get(i).getS_name());
        p_name.setText(data.get(i).getP_name());
        p_point.setText(data.get(i).getPoint());
        p_price.setText(data.get(i).getPrice());
        p_img.setImageResource(data.get(i).getImg());

        p_change.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"옵션을 변경하시겠습니까?",
                        Toast.LENGTH_SHORT).show();
            }
        });
        p_cnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"수량을 변경하시겠습니까?",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
