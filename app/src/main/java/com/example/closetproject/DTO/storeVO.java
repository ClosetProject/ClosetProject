package com.example.closetproject.DTO;

public class storeVO {

    private String seq;

    private String s_name;
    private String concept;

    public storeVO(String seq, String s_name, String concept) {
        this.seq = seq;

        this.s_name = s_name;
        this.concept = concept;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }


    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }
}
