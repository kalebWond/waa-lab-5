package com.example.Lab4.repositories;

import com.example.Lab4.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(long postId);
    Comment findByIdAndPostId(long id, long postId);
}
