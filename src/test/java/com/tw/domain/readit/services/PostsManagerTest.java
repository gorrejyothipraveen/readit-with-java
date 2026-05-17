package com.tw.domain.readit.services;

import com.tw.domain.readit.dTo.Post;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostsManagerTest {
    @Test
    void shouldBeAbleCreatePostManager() {
        PostService postsManager = new PostService();
        assertEquals(new PostService(), postsManager);
    }

    @Test
    void shouldBeAbleToAddPost() {
        PostService postsManager = new PostService();
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        int id = postsManager.addPost(post);
        assertEquals(0,id);
    }

    @Test
    void shouldRemovePostIfPostExist() {
        PostService postsManager = new PostService();
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        int id = postsManager.addPost(post);
        assertEquals(id, postsManager.removePost(id));
    }
}
