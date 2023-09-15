package com.ad.aditi.controller;

import com.ad.aditi.payload.PostDto;
import com.ad.aditi.service.PostService;
import com.ad.aditi.service.impl.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/posts/")

public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    // create blog post rest api

    //http://localhost:8089/api/posts
    @PreAuthorize("hasRole('Admin')") // only login as admin can access it security //
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult result) {

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

        // For Emailvalidation //
        //@Email(message="please provides a valid email address" )
        //private String email
    }

    //http://localhost:8089/api/posts/1?pageNo=0&pageSize=10&&sortBy=Id/title&sortDir=asc
    @GetMapping
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir

            ) {
        PostResponse postResponse = postService.getAllposts(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity(postResponse, HttpStatus.OK);
    }

    //http://localhost:8089/api/posts/1


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(
            @PathVariable("id") long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);

    }

    //http://localhost:8089/api/posts/1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
                                              @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return ResponseEntity.ok(postResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(
            @PathVariable(name = "id") long id
    ) {

        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}

