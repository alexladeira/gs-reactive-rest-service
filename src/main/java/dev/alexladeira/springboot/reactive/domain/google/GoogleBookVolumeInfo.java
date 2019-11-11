package dev.alexladeira.springboot.reactive.domain.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBookVolumeInfo {
    public String title;
    public String[] authors;
    public String printType;
}
