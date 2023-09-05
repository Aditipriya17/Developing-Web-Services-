package com.blog.service;

import com.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    public PostDto createPost(PostDto postDto , Long postId);
}
