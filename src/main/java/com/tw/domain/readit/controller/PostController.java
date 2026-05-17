package com.tw.domain.readit.controller;

import com.tw.domain.readit.dTo.Post;
import com.tw.domain.readit.dTo.PostResponse;
import com.tw.domain.readit.services.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Integer> createPost(@RequestBody Post post) {
        logger.info("/posts add request");
        int id = postService.addPost(post);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> createPost(@PathVariable int id) {
        logger.info("/posts delete request");
        return ResponseEntity.ok(postService.removePost(id));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> createPost() {
        logger.info("/posts delete request");
        return ResponseEntity.ok(postService.getPosts());
    }
}
