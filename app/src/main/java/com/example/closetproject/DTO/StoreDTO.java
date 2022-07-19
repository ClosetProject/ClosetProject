package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreDTO {
    @SerializedName("S_SEQ")
    private String s_seq;    // 순번

    @SerializedName("S_NAME")
    private String s_name; // 가게명

    @SerializedName("S_IMG")
    @Expose
    private String s_img;  // 이미지 경로

    @SerializedName("S_TEL")
    @Expose
    private String s_tel;  // 전화번호

    @SerializedName("S_ADDR")
    @Expose
    private String s_addr; // 주소

    @SerializedName("STYLE")
    @Expose
    private String s_desc; // 쇼핑몰 설명

    /**
     * 생성자
     **/
    public StoreDTO() {
        super();
    }

    public StoreDTO(String s_seq, String s_name, String s_img, String s_tel, String s_addr, String s_desc) {
        this.s_seq = s_seq;
        this.s_name = s_name;
        this.s_img = s_img;
        this.s_tel = s_tel;
        this.s_addr = s_addr;
        this.s_desc = s_desc;
    }

    public StoreDTO(String s_seq, String s_name, String s_desc) {
        this.s_seq = s_seq;
        this.s_name = s_name;
        this.s_desc = s_desc;
    }

    /**
     * getter / setter
     **/
    public String getS_seq() {
        return s_seq;
    }

    public void setS_seq(String s_seq) {
        this.s_seq = s_seq;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_img() {
        return s_img;
    }

    public void setS_img(String s_img) {
        this.s_img = s_img;
    }

    public String getS_tel() {
        return s_tel;
    }

    public void setS_tel(String s_tel) {
        this.s_tel = s_tel;
    }

    public String getS_addr() {
        return s_addr;
    }

    public void setS_addr(String s_addr) {
        this.s_addr = s_addr;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }
}
