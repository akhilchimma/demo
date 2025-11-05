package com.example.demo.model;

import com.example.demo.model.Company;
import java.util.List;


public class ListCompanies {
    public boolean isSuccessful;
    public int resultsCount;
    public List<Company> data;

    public ListCompanies() {}

    public boolean getIsSuccessful() {
        return isSuccessful;
    }
    public int getResultsCount() {
        return resultsCount;
    }
    public List<Company> getData() {
        return data;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }
    public void setData(List<Company> data) {
        this.data = data;
    }
}
