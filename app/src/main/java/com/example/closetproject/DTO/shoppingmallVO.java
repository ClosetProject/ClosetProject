package com.example.closetproject.DTO;

public class shoppingmallVO {

    private String price;
    private String s_name;
    private String p_name;
    private int img;

    public shoppingmallVO(String price, String s_name, String p_name, int img) {
        this.price = price;
        this.s_name = s_name;
        this.p_name = p_name;
        this.img = img;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
