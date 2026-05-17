package com.tw.domain.readit.services;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.dTo.PostResponse;
import com.tw.domain.readit.model.InvalidPostException;
import com.tw.domain.readit.repositories.PostRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PostService {


    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PostService that = (PostService) o;
        return Objects.equals(postRepo, that.postRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(postRepo);
    }

    public int addPost(Post post) {
        if(post.title() == null || post.title().isEmpty()) {
            throw new InvalidPostException("Invalid Post Title");
        }
        return postRepo.addPost(post);
    }

    public int removePost(int id) {
        Post post = postRepo.getPost(id);
        if(post == null) {
            throw new InvalidPostException("Post must not be NULL");
        }

        return postRepo.removePost(id);
    }

    public List<PostResponse> getPosts() {
        return postRepo.getPosts()
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
