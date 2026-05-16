package com.tw.domain.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Test
    void shouldBeAbleToGiveNameToPost() {
        Post post = new Post("praveen", "First Post", "12-03-2022", "This is the content of post");
        assertEquals(new Post("praveen", "First Post", "12-03-2022", "This is the content of post"), post);
    }


}