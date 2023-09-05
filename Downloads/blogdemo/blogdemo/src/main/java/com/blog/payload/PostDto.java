package com.blog.payload;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;

    private List<CommentDto> comments;
}
