package com.example.demo.model;

import java.util.List;
import com.example.demo.model.Company;

public class ListQuery {
    public boolean success;
    public String query;
    public int results_count;
    public List<Company> search_results; 

    public ListQuery() {}

    public boolean getSuccess() {
        return success;
    }
    public String getQuery() {
        return query;
    }
    public int getResults_count() {
        return results_count;
    }
    public List<Company> getSearch_results() {
        return search_results;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public void setResults_count(int results_count) {
        this.results_count = results_count;
    }
    public void setSearch_results(List<Company> search_results) {
        this.search_results = search_results;
    }

}
