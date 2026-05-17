package com.tw.domain.readit.controller;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.List;

@SpringBootTest

@AutoConfigureRestTestClient
public class PostControllerTest {

    @Autowired
    private  RestTestClient client;

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Test
    void shouldThrowErrorIfTriesToRemoveNonExistingPost() {
        client.delete()
                .uri("/posts/0")
                .exchange()
                .expectStatus().isNotFound();
    }

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Test
    void shouldReturnPosts() {
        Post post1 = new Post("praveen", "title", "12-12-2022","content");

        client.post()
                .uri("/posts")
                .body(post1)
                .exchange()
                .expectStatus().isOk();

        client.get()
                .uri("/posts")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].title").isEqualTo("title");
    }

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Test
    void shouldThrowAnErrorIfInvalidTitleNameIsGiven() {
        Post post = new Post("praveen", null, "12-12-2022", "content");
        client.post()
                .uri("/posts")
                .body(post)
                .exchange()
                .expectStatus().isNotFound();
    }
}
