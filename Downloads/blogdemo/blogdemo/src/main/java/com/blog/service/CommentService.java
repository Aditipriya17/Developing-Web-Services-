package com.blog.service;

import com.blog.entities.Comment;
import com.blog.payload.CommentDto;

public interface CommentService {

    public CommentDto createComment (Long postId, CommentDto commentDto);
}
