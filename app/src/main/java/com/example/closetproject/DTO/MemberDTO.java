package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberDTO {

    // @SerializedName : 매핑 => 서버에서 받아오는 json명칭과 일치
    // @Expose : object 중 해당 값이 null인 경우 필드 자동 생략
    @SerializedName("m_email")
    private String m_email;

    @SerializedName("m_pw")
    private String m_pw;

    @SerializedName("m_name")
    @Expose
    private String m_name;

    @SerializedName("m_type")
    @Expose
    private String m_type = "N";

    @SerializedName("m_joindate")
    @Expose
    private String m_joindate;

    // 생성자
    public MemberDTO(String m_email, String m_pw){
        this.m_email = m_email;
        this.m_pw = m_pw;
    }

    public MemberDTO(String m_email, String m_pw, String m_name, String m_type, String m_joindate) {
        this.m_email = m_email;
        this.m_pw = m_pw;
        this.m_name = m_name;
        this.m_type = m_type;
        this.m_joindate = m_joindate;
    }

    // Getter, Setter


    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getM_pw() {
        return m_pw;
    }

    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_type() {
        return m_type;
    }

    public void setM_type(String m_type) {
        this.m_type = m_type;
    }

    public String getM_date() {
        return m_joindate;
    }

    public void setM_date(String m_date) {
        this.m_joindate = m_date;
    }
}
