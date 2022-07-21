package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasketDTO {

    @SerializedName("S_SEQ")
    @Expose
    private String s_seq;

    @SerializedName("P_CODE")
    @Expose
    private String p_code;

    @SerializedName("P_CNT")
    @Expose
    private int p_cnt;

    @SerializedName("M_EMAIL")
    @Expose
    private String m_email;

    @SerializedName("P_COLOR")
    @Expose
    private int p_color;

    @SerializedName("P_SIZE")
    @Expose
    private int p_size;

    // 생성자
    public BasketDTO(String p_code, int p_cnt, String m_email, int p_color, int p_size) {
        this.p_code = p_code;
        this.p_cnt = p_cnt;
        this.m_email = m_email;
        this.p_color = p_color;
        this.p_size = p_size;
    }
    public BasketDTO(String s_seq, String p_code, int p_cnt, String m_email, int p_color, int p_size) {
        this.s_seq = s_seq;
        this.p_code = p_code;
        this.p_cnt = p_cnt;
        this.m_email = m_email;
        this.p_color = p_color;
        this.p_size = p_size;
    }

    // Getter, Setter
    public String getS_seq() {
        return s_seq;
    }

    public void setS_seq(String s_seq) {
        this.s_seq = s_seq;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public int getP_cnt() {
        return p_cnt;
    }

    public void setP_cnt(int p_cnt) {
        this.p_cnt = p_cnt;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public int getP_color() {
        return p_color;
    }

    public void setP_color(int p_color) {
        this.p_color = p_color;
    }

    public int getP_size() {
        return p_size;
    }

    public void setP_size(int p_size) {
        this.p_size = p_size;
    }
}
