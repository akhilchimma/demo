package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Financials;
import com.example.demo.model.Historicals;
import com.example.demo.model.ListCompanies;
import com.example.demo.model.ListQuery;
import com.example.demo.service.HttpMakeCalls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Company;
import com.example.demo.model.ListQuery;
import com.example.demo.model.Financials;
import com.example.demo.model.Historicals;
import com.example.demo.model.ListCompanies;


@RestController
@RequestMapping("/api")
public class FinCruxController {

    private final HttpMakeCalls serivice;

    @Autowired
    public FinCruxController(HttpMakeCalls serivice) {
        this.serivice = serivice;
    }
    
    @RequestMapping(value = "/all_companies", method = RequestMethod.GET)
    public ResponseEntity<ListCompanies> getAllCompanies() {
        ListCompanies response = serivice.getAllCompanies();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/search/{symbol}", method=RequestMethod.GET)
    public ResponseEntity<ListQuery> getSym(@PathVariable String symbol) {
        ListQuery response = serivice.searchCompany(symbol);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/financials/{key}", method=RequestMethod.GET)
    public ResponseEntity<Financials> getFinancials(@PathVariable String key) {
        Financials response = serivice.getFinancials(key);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/historicals/{key}", method=RequestMethod.GET)
    public ResponseEntity<Historicals> getHistoricals(@PathVariable String key) {
        Historicals response = serivice.getHistoricals(key);
        return ResponseEntity.ok(response);
    }
    
}
