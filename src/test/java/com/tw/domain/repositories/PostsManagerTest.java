package com.tw.domain.repositories;

import com.tw.domain.services.PostsManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostsManagerTest {
    @Test
    void shouldBeAbleCreatePostManager() {
        PostsManager postsManager = new PostsManager();
        assertEquals(new PostsManager(), postsManager);
    }

    @Test
    void shouldBeAbleToAddPost() {
        PostsManager postsManager = new PostsManager();
        int id = postsManager.addPost("praveen", "title", "12-12-2022", "content");
        assertEquals(0,id);
    }

    @Test
    void shouldRemovePostIfPostExist() {
        PostsManager postsManager = new PostsManager();
        int id = postsManager.addPost("praveen", "title", "12-12-2022", "content");
        assertEquals(id, postsManager.removePost(id));
    }
}
