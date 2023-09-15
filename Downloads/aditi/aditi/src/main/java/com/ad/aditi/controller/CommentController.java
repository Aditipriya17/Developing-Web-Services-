package com.ad.aditi.controller;
import com.ad.aditi.payload.CommentDto;
import com.ad.aditi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8089/api/posts/1/comments
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId,
                commentDto), HttpStatus.CREATED);
    }

    //http://localhost:8089/api/posts/1/comments
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId")
                                                Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    //http://localhost:8089/api/posts/1/comments/{1}
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value =
            "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId,
                commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
    //http://localhost:8089/api/posts/{postId}/comments/{1\id}

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") long postId, @PathVariable("id") long id, @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService.updateCommentById(postId, id, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long
                                                        postId,
                                                @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }


}



