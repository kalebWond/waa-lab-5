package com.example.Lab4.repositories;

import com.example.Lab4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE size(u.posts) > :count")
    List<User> getUsersWithMultiplePosts(int count);

    @Query("SELECT DISTINCT u FROM User u JOIN u.posts p WHERE lower(p.title) = lower(:title)")
    List<User> getUsersByPostTitle(String title);

    Optional<User> findByName(String name);

}
