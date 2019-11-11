package dev.alexladeira.springboot.reactive.services;

import reactor.core.publisher.Flux;

import java.time.Duration;

public interface GenericService<T> {
    int MAX_RESULTS = 5;
    Duration TIMEOUT = Duration.ofSeconds(20L);

    Flux<T> getBooksBy(String searchTerm);
}
