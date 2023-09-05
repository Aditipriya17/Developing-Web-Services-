package com.blog.controller;


import com.blog.entities.Post;
import com.blog.payload.PostDto;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8089/api/posts
    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {


        PostDto savedPostDto = postService.createPost(postDto);

        return new ResponseEntity<>(savedPostDto , HttpStatus.CREATED);
    }
}
