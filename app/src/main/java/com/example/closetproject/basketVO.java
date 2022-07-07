package com.example.closetproject;

public class basketVO {


    private String point;
    private String p_name;
    private String price;
    private String s_name;
    private int img;

    public basketVO(String s_name, String p_name, String price, String point, int img) {
        this.p_name = p_name;
        this.s_name = s_name;
        this.price = price;
        this.point = point;
        this.img = img;
    }


    public String getPoint() {return point;}

    public void setPoint(String point) {this.point = point;}

    public String getP_name() {return p_name;}

    public void setP_name(String p_name) {this.p_name = p_name;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;}

    public String getS_name() {return s_name;}

    public void setS_name(String s_name) {this.s_name = s_name;}

    public int getImg() {return img;}

    public void setImg(int img) {this.img = img;}





}
