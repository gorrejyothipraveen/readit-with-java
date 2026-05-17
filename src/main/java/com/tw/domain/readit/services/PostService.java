package com.tw.domain.readit.services;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.model.InvalidPostException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PostService {
    private final Map<Integer, Post> posts;
    private int currentPostId = 0;

    public PostService() {
        this.posts = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PostService that = (PostService) o;
        return Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(posts);
    }

    public int addPost(Post post) {
        int id = currentPostId;
        posts.put(id, post);
        currentPostId++;
        return id;
    }

    public int removePost(int id) {
        Post post = posts.get(id);
        if(post == null) {
            throw new InvalidPostException("Post must not be NULL");
        }

        posts.remove(id);
        return id;
    }
}
