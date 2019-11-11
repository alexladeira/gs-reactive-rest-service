package dev.alexladeira.springboot.reactive.handlers;

import dev.alexladeira.springboot.reactive.domain.google.GoogleBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import dev.alexladeira.springboot.reactive.services.GoogleBooksService;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan({"services"})
public class GoogleBooksHandler {

    @Autowired
    private GoogleBooksService googleBooksService;

    public Mono<ServerResponse> search(ServerRequest request) {
        String searchTerm = request.queryParam("searchTerm").orElse(null);
        return searchTerm != null ? ServerResponse.ok().body(BodyInserters.fromPublisher(this.googleBooksService.getBooksBy(searchTerm).reduce(new ArrayList<GoogleBook>(), (list, googleBookServiceResponse) -> {
            list.addAll(googleBookServiceResponse.items);
            return list;
        }), List.class)) : ServerResponse.badRequest().build();
    }
}
