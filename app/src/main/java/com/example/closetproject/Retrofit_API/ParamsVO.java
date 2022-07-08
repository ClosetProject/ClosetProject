package com.example.closetproject.Retrofit_API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class ParamsVO {
    @SerializedName("sql")
    private String sql;

    @SerializedName("header")
    @Expose
    private String[] header = null;

    @SerializedName("params")
    private String[] params = null;

    public ParamsVO(String sql, String[] params) {
        this.sql = sql;
        this.params = params;
    }

    public ParamsVO(String sql, String[] header, String[] params) {
        this.sql = sql;
        this.header = header;
        this.params = params;
    }
}
