package dev.alexladeira.springboot.reactive.domain.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBook {
    public GoogleBookVolumeInfo volumeInfo;
}
