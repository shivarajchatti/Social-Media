package com.shivaraj.new_website.repository;

import com.shivaraj.new_website.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query("select p from Post p where p.user.id=:id")
    List<Post> findPostByUserId(Integer id);
}
