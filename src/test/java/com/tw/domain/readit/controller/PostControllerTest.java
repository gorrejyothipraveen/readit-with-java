package com.tw.domain.readit.controller;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest

@AutoConfigureRestTestClient
public class PostControllerTest {

    @Autowired
    private RestTestClient client;

    @Test
    void shouldAddThePost() {
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        client.post()
                .uri("/posts")
                .body(post)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .isEqualTo(0);
    }

    @Test
    void shouldRemovesThePostFromExistingPosts() {
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        client.post()
                .uri("/posts")
                .body(post)
                .exchange()
                .expectStatus().isOk();

        client.delete()
                .uri("/posts/0")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .isEqualTo(0);
    }
}
