package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.model.Company;
import com.example.demo.model.ListCompanies;
import com.example.demo.model.Financials;
import com.example.demo.model.Historicals;
import com.example.demo.model.ListQuery;

import com.example.demo.model.ListCompanies;
import com.example.demo.model.Company;

@Slf4j
@Service
public class HttpMakeCalls {
    private final String url;
    private final String api_key;
    private final WebClient webClient;

    // Constructor 
    public HttpMakeCalls(
        @Value("${fincrux.api.url}") String url,
        @Value("${fincrux.api.key}") String api_key
    ) {
        this.url = url;
        this.api_key = api_key;
        
        ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB
            .build();

        this.webClient = WebClient.builder()
                .baseUrl(this.url)
                .exchangeStrategies(strategies)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private <T> T makeGetRequest(String url, Class<T> responseType) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path(url)
                    .queryParam("api_key", this.api_key)
                    .build())
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }

    @Cacheable("allCompanies")
    public ListCompanies getAllCompanies() {
        String url = "/api/all_companies";
        log.info("Fetching all companies from API");
        return makeGetRequest(url, ListCompanies.class);
    }

    @Cacheable(value = "searchCompany", key="#company")
    public ListQuery searchCompany(String company) {
        String url = "/api/search/" + company;
        log.info("Searching company: {}", company);
        return makeGetRequest(url, ListQuery.class);
    }

    public Financials getFinancials(String key) {
        String url = "/api/financials/" + key;

        return makeGetRequest(url, Financials.class);
    }

    @Cacheable(value = "historicals", key="#key")
    public Historicals getHistoricals(String key) {
        String url = "/api/historicals/" + key;
        log.info("Fetching historicals for key: {}", key);
        return makeGetRequest(url, Historicals.class);
    }
}
