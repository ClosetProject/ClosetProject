package com.example.closetproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.closetproject.DTO.MyPageDTO;
import com.example.closetproject.DTO.PColorDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.GlobalVariate;
import com.example.closetproject.R;
import com.example.closetproject.DTO.myPageVO;

import java.util.ArrayList;

public class myPageCA extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<ProductDTO> data;
    private LayoutInflater inflater;

    public myPageCA(Context context, int layout, ArrayList<ProductDTO> data) {
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

        TextView p_my_name = view.findViewById(R.id.p_my_name);
        TextView p_my_price = view.findViewById(R.id.p_my_price);
        ImageView p_my_img = view.findViewById(R.id.p_my_img);

        if(data.get(i).getColorList().size() > 0){
            ArrayList<PColorDTO> colorList = data.get(i).getColorList();
            String[] imgList = new String[colorList.size()];
            for(int c = 0; c < colorList.size(); c++){
                String colorName = colorList.get(c).getColor_name();
                String imgPath = GlobalVariate.getInstance().getBaseURL() + data.get(i).getP_img() + colorName + ".jpg";
                imgList[c] = imgPath;
            }

            Glide.with(context)
                    .load(imgList[0])
                    .error(R.drawable.noimg)
                    .into(p_my_img);
        }else{
            Glide.with(context)
                    .load(R.drawable.noimg)
                    .error(R.drawable.noimg)
                    .into(p_my_img);
        }

        p_my_name.setText(data.get(i).getP_name());
        p_my_price.setText(data.get(i).getP_price());

        return view;
    }
}
