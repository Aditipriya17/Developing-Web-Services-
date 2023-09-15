package com.ad.aditi.service;

import com.ad.aditi.payload.CommentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateCommentById(Long postId, Long id,CommentDto commentId);

    void deleteComment(Long postId, Long commentId);
}
