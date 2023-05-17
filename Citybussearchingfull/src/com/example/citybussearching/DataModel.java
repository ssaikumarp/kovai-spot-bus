package com.example.citybussearching;

public class DataModel {

    public String sname,regno,std;
    boolean checked;

    DataModel(String regno,String sname,String std, boolean checked) {
        this.regno = regno;
        this.sname = sname;
        this.std = std;
        this.checked = checked;

    }

}
