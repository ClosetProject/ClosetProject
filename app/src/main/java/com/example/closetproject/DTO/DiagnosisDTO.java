package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiagnosisDTO {

    @SerializedName("D_SEQ")
    @Expose
    private int d_seq;

    @SerializedName("D_L")
    @Expose
    private int d_l;

    @SerializedName("D_A")
    @Expose
    private int d_a;

    @SerializedName("D_B")
    @Expose
    private int d_b;

    @SerializedName("D_S")
    @Expose
    private int d_s;

    @SerializedName("D_V")
    @Expose
    private int d_v;

    @SerializedName("D_RESULT")
    @Expose
    private String d_result;

    @SerializedName("M_EMAIL")
    @Expose
    private String m_email;

    public DiagnosisDTO(int d_seq, int d_l, int d_a, int d_b, int d_s, int d_v, String d_result, String m_email) {
        this.d_seq = d_seq;
        this.d_l = d_l;
        this.d_a = d_a;
        this.d_b = d_b;
        this.d_s = d_s;
        this.d_v = d_v;
        this.d_result = d_result;
        this.m_email = m_email;
    }

    public int getD_seq() {
        return d_seq;
    }

    public void setD_seq(int d_seq) {
        this.d_seq = d_seq;
    }

    public int getD_l() {
        return d_l;
    }

    public void setD_l(int d_l) {
        this.d_l = d_l;
    }

    public int getD_a() {
        return d_a;
    }

    public void setD_a(int d_a) {
        this.d_a = d_a;
    }

    public int getD_b() {
        return d_b;
    }

    public void setD_b(int d_b) {
        this.d_b = d_b;
    }

    public int getD_s() {
        return d_s;
    }

    public void setD_s(int d_s) {
        this.d_s = d_s;
    }

    public int getD_v() {
        return d_v;
    }

    public void setD_v(int d_v) {
        this.d_v = d_v;
    }

    public String getD_result() {
        return d_result;
    }

    public void setD_result(String d_result) {
        this.d_result = d_result;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }
}
