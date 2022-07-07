package com.example.closetproject;

import android.widget.ImageView;

public class orderVO {

    private String date;
    private String price;
    private String s_name;
    private String p_name;
    private String color;
    private String size;
    private int img;

    public orderVO(String date, String price, String s_name, String p_name, String color, String size, int img) {
        this.date = date;
        this.price = price;
        this.s_name = s_name;
        this.p_name = p_name;
        this.color = color;
        this.size = size;
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
