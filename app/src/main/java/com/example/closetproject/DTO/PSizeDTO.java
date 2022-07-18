package com.example.closetproject.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSizeDTO {

    @SerializedName("SIZE_SEQ")
    @Expose
    private String size_seq;

    @SerializedName("SIZE_NAME")
    @Expose
    private String size_name;

    @SerializedName("SIZE_DESC")
    @Expose
    private String size_desc;

    @SerializedName("SIZE_PART")
    @Expose
    private String size_part;

    public PSizeDTO(String size_seq, String size_name, String size_desc, String size_part) {
        this.size_seq = size_seq;
        this.size_name = size_name;
        this.size_desc = size_desc;
        this.size_part = size_part;
    }

    public String getSize_seq() {
        return size_seq;
    }

    public void setSize_seq(String size_seq) {
        this.size_seq = size_seq;
    }

    public String getSize_name() {
        return size_name;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }

    public String getSize_desc() {
        return size_desc;
    }

    public void setSize_desc(String size_desc) {
        this.size_desc = size_desc;
    }

    public String getSize_part() {
        return size_part;
    }

    public void setSize_part(String size_part) {
        this.size_part = size_part;
    }
}
