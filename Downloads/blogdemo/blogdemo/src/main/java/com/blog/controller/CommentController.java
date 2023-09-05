package com.blog.controller;

import com.blog.entities.Post;
import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }

        //http://localhost:8089/api/posts/1/coents
    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> saveComment(@PathVariable Long postId, @RequestBody CommentDto commentDto
    ) {
        CommentDto savedCommentDto  = commentService.createComment(postId, commentDto);
        return new  ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
    }
}

