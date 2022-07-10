package com.example.closetproject.DTO;

public class mainVO {

    private String s_name;
    private String p_name;
    private int img;

    public mainVO(String s_name, int img) {
        this.s_name = s_name;

        this.img = img;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
