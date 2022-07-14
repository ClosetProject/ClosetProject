package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDTO {

    @SerializedName("P_CODE")
    private String p_code;

    @SerializedName("P_NAME")
    private String p_name;

    @SerializedName("P_IMG")
    @Expose
    private String p_img;

    @SerializedName("P_CAT")
    private String p_cat;

    @SerializedName("P_PRICE")
    private String p_price;

    @SerializedName("S_NAME")
    @Expose
    private String s_name;

    @SerializedName("S_SEQ")
    @Expose
    private int s_seq;

    @SerializedName("COLOR_NAME")
    @Expose
    private String color_name;

    @SerializedName("C_CODE")
    @Expose
    private String c_code;

    // 생성자
    public ProductDTO(String p_code, String p_name, String p_img, String p_cat, String p_price, String s_name, int s_seq) {
        this.p_code = p_code;
        this.p_name = p_name;
        this.p_img = p_img;
        this.p_cat = p_cat;
        this.p_price = p_price;
        this.s_name = s_name;
        this.s_seq = s_seq;
    }

    public ProductDTO(String p_code, String p_name, String p_img, String p_cat, String p_price, String s_name, int s_seq, String color_name, String c_code) {
        this.p_code = p_code;
        this.p_name = p_name;
        this.p_img = p_img;
        this.p_cat = p_cat;
        this.p_price = p_price;
        this.s_name = s_name;
        this.s_seq = s_seq;
        this.color_name = color_name;
        this.c_code = c_code;
    }

    // Getter , Setter
    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_img() {
        return p_img;
    }

    public void setP_img(String p_img) {
        this.p_img = p_img;
    }

    public String getP_cat() {
        return p_cat;
    }

    public void setP_cat(String p_cat) {
        this.p_cat = p_cat;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getS_seq() {
        return s_seq;
    }

    public void setS_seq(int s_seq) {
        this.s_seq = s_seq;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }
}
