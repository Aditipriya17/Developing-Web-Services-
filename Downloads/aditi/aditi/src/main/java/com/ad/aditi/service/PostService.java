package com.ad.aditi.service;

import antlr.collections.List;
import com.ad.aditi.payload.PostDto;
import com.ad.aditi.service.impl.PostResponse;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllposts(int pageNo, int pageSize, String sortBy , String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
