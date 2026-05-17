package com.tw.domain.readit.repositories;

import com.tw.domain.readit.dTo.Post;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepoTest {
    @Test
    void shouldAddPost() {
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        PostRepo postRepo = new PostRepo();
        int id = postRepo.addPost(post);
        assertEquals(0, id);
    }

    @Test
    void shouldRemovePost() {
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        PostRepo postRepo = new PostRepo();
        int id = postRepo.addPost(post);
        int removedId = postRepo.removePost(id);
        assertEquals(id, removedId);
    }

    @Test
    void shouldReturnAllPosts() {
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        PostRepo postRepo = new PostRepo();
        int id = postRepo.addPost(post);
        List<Map.Entry<Integer, Post>> posts = postRepo.getPosts();
        assertEquals("title", posts.getFirst().getValue().title());
    }

    @Test
    void shouldReturnPostBasedOnIdGiven() {
        Post post = new Post("praveen", "title", "12-12-2022", "content");
        PostRepo postRepo = new PostRepo();
        int id = postRepo.addPost(post);
        Post post1 = postRepo.getPost(id);
        assertEquals("praveen", post1.author());
    }
}
