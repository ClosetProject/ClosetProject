package com.example.closetproject;

public class GlobalVariate {
    private String m_email;
    private String baseURL = "http://121.147.185.76:8081/";
    private String d_season;
    private int[] self_cnt = new int[]{0, 0, 0, 0};

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {this.baseURL = baseURL;}

    public String getD_season() {
        return d_season;
    }

    public void setD_season(String d_season) {
        this.d_season = d_season;
    }

    public void addSelf_cnt(int idx, int num){
        self_cnt[idx] = num;
    }

    public String getSelf_cnt(){
        int cnt = 0;
        for(int i = 0; i < self_cnt.length; i++){
            if(self_cnt[i] <= 2){ cnt += 1;}
        }

        if(d_season.equals("SW") && cnt <= 2){
            d_season = "SWB";
        }else if(d_season.equals("SW") && cnt > 2){
            d_season = "SWL";
        }else if(d_season.equals("SC") && cnt <= 2) {
            d_season = "SCM";
        }else if(d_season.equals("SC") && cnt > 2){
            d_season = "SCL";
        }else if(d_season.equals("AW") && cnt <= 2) {
            d_season = "AWM";
        }else if(d_season.equals("AW") && cnt > 2){
            d_season = "AWD";
        }else if(d_season.equals("WC") && cnt <= 2) {
            d_season = "WCB";
        }else{
            d_season = "WCD";
        }

        return d_season;
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
