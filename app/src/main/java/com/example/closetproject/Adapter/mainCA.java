package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class mainCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<ProductDTO> data;
    private LayoutInflater inflater;

    private TextView tv_mpd_price, tv_mpd_name, tv_mpd_store;
    private ImageView iv_mpd_img, iv_mwishlist;

    public mainCA(Context context, int layout, ArrayList<ProductDTO> data) {
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

        tv_mpd_price = view.findViewById(R.id.tv_mpd_price);
        tv_mpd_name = view.findViewById(R.id.tv_mpd_name);
        tv_mpd_store = view.findViewById(R.id.tv_mpd_store);
        iv_mpd_img = view.findViewById(R.id.iv_mpd_img);
        iv_mwishlist = view.findViewById(R.id.iv_mwishlist);

        //text
        tv_mpd_price.setText(data.get(i).getP_price());
        tv_mpd_name.setText(data.get(i).getP_name());
        tv_mpd_store.setText(data.get(i).getS_name());

        String img_path = "http://121.147.185.76:8081/" + data.get(i).getP_img() + "/BLACK.jpg";
        Glide.with(context)
                .load(img_path)
                .error(R.drawable.noimg)
                .into(iv_mpd_img);

        return view;
    }
}
