package dev.alexladeira.springboot.reactive.routes;

import dev.alexladeira.springboot.reactive.domain.google.GoogleBookServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@WebFluxTest(SearchRouter.class)
public class SearchRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void search() {
        webTestClient.get().uri("/search?searchTerm=tempo").exchange().expectStatus().isOk().expectBodyList(GoogleBookServiceResponse.class);
    }
}