package com.tw.domain.readit.services;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.repositories.PostRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostServiceTest {
    @Test
    void shouldBeAbleCreatePostManager() {
        PostRepo postRepo = new PostRepo();
        PostService postsManager = new PostService(postRepo);
        assertEquals(new PostService(postRepo), postsManager);
    }

    @Test
    void shouldBeAbleToAddPost() {
        PostService postsManager = new PostService(new PostRepo());
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        int id = postsManager.addPost(post);
        assertEquals(0,id);
    }

    @Test
    void shouldRemovePostIfPostExist() {
        PostService postsManager = new PostService(new PostRepo());
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        int id = postsManager.addPost(post);
        assertEquals(id, postsManager.removePost(id));
    }
}
