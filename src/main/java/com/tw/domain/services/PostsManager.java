package com.tw.domain.services;

import com.tw.domain.repositories.Post;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PostsManager {
    private final Map<Integer, Post> posts;
    private int currentPostId = 0;

    public PostsManager() {
        this.posts = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PostsManager that = (PostsManager) o;
        return Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(posts);
    }

    public int addPost(String author, String title, String date, String content) {
        Post post = new Post(author, title, date, content);
        int id = currentPostId;
        posts.put(id, post);
        currentPostId++;
        return id;
    }
}
