package dev.alexladeira.springboot.reactive.domain.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBookServiceResponse {
    public List<GoogleBook> items;
}
