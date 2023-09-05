package com.blog.payload;

import lombok.Data;

import java.util.List;

@Data
public class CommentDto {
    private Long id;
    private String body;
    private String email;
    private String name;

    private List<CommentDto> comments; //For the post u want all the comment//
}
