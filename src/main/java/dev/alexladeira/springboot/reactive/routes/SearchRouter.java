package dev.alexladeira.springboot.reactive.routes;

import dev.alexladeira.springboot.reactive.handlers.GoogleBooksHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@ComponentScan({"handlers"})
public class SearchRouter {
    @Bean
    public RouterFunction<ServerResponse> search(GoogleBooksHandler googleBooksHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/search"), googleBooksHandler::search);
    }
}