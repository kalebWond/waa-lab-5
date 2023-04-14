package com.example.Lab4.services;

import com.example.Lab4.domain.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> findAllByPostId(long postId);

    Comment getById(long id);

    void save(Comment p);


}
