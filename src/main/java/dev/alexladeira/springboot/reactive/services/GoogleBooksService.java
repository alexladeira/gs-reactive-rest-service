package dev.alexladeira.springboot.reactive.services;

import dev.alexladeira.springboot.reactive.domain.google.GoogleBookServiceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class GoogleBooksService implements GenericService<GoogleBookServiceResponse> {
    private WebClient webClient = WebClient.builder().baseUrl("https://content.googleapis.com").build();

    @Override
    public Flux<GoogleBookServiceResponse> getBooksBy(String searchTerm) {
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .path("/books/v1/volumes")
                .queryParam("q", searchTerm)
                .queryParam("maxResults", MAX_RESULTS)
                .build()).retrieve().bodyToFlux(GoogleBookServiceResponse.class).timeout(TIMEOUT);
    }
}
