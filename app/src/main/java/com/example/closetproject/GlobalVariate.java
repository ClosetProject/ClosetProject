package com.example.closetproject;

public class GlobalVariate {
    private String m_email;
    private String baseURL = "http://121.147.185.76:8081/";

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
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
