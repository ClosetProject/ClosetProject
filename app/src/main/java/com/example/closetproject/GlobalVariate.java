package com.example.closetproject;

public class GlobalVariate {
    private String m_email;

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    //싱글톤
    private static GlobalVariate instance = null;
    public static synchronized GlobalVariate getInstance() {
        if (null == instance) {
            instance = new GlobalVariate();
        }
        return instance;
    }
}
