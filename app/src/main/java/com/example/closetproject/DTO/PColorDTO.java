package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PColorDTO {

    @SerializedName("COLOR_SEQ")
    @Expose
    private String color_seq;

    @SerializedName("COLOR_NAME")
    @Expose
    private String color_name;

    @SerializedName("C_CODE")
    @Expose
    private String c_code;

    public PColorDTO(String color_seq, String color_name, String c_code) {
        this.color_seq = color_seq;
        this.color_name = color_name;
        this.c_code = c_code;
    }

    public String getColor_seq() {
        return color_seq;
    }

    public void setColor_seq(String color_seq) {
        this.color_seq = color_seq;
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
