package com.example.Lab4.services;

import com.example.Lab4.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    PostDto getById(long id);

    void save(PostDto p);

    void delete(long id);

    void update(long id, PostDto p);

    public List<PostDto> findByAuthor(String author);

    public List<PostDto> findByTitle(String title);

}
