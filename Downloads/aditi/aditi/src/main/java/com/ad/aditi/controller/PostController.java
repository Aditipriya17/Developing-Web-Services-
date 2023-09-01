package com.ad.aditi.controller;


import com.ad.aditi.payload.PostDto;
import com.ad.aditi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/posts/")

public class PostController {

    private PostService postService;
        public PostController(PostService postService) {
            this.postService = postService;
        }
        // create blog post rest api

        //http://localhost:8088/api/posts

    @PostMapping
        public ResponseEntity<PostDto> createPost( PostDto postDto){
            PostDto dto = postService.createPost(postDto);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
    }

