package com.tw.domain.readit.repositories;

import com.tw.domain.readit.dTo.Post;import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepo {
    private final Map<Integer, Post> posts;
    private int currentPostId = 0;

    public PostRepo() {
        this.posts = new HashMap<>();
    }

    public int addPost(Post post) {
        int id = currentPostId;
        posts.put(id, post);
        currentPostId++;
        return id;
    }

    public int removePost(int id) {
        posts.remove(id);
        return id;
    }

    public List<Map.Entry<Integer, Post>> getPosts() {
        return new ArrayList<>(posts.entrySet());
    }

    public Post getPost(int id) {
        return  posts.get(id);
    }
}
