package com.tw.domain.readit.services;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.dTo.PostResponse;
import com.tw.domain.readit.model.InvalidPostException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
        if(post.title() == null || post.title().isEmpty()) {
            throw new InvalidPostException("Invalid Post Title");
        }
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

    public List<PostResponse> getPosts() {
        return posts.entrySet()
                .stream()
                .map(e ->
                        new PostResponse(e.getKey(),
                        e.getValue().author(),
                        e.getValue().title(),
                        e.getValue().date(),
                        e.getValue().content()))
                .toList();
    }
}
