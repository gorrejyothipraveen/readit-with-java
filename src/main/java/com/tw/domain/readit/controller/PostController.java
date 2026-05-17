package com.tw.domain.readit.controller;

import com.tw.domain.readit.dTo.Post;import com.tw.domain.readit.services.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;

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



}
