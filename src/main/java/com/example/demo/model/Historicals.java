package com.example.demo.model;

import java.util.List;
import com.example.demo.model.Candle;

public class Historicals {
    public boolean success;
    public String company;
    public List<Candle> data;

    public Historicals() {}

    public boolean getSuccess() {
        return success;
    }
    public String getCompany() {
        return company;
    }
    public List<Candle> getData() {
        return data;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setData(List<Candle> data) {
        this.data = data;
    }
}
