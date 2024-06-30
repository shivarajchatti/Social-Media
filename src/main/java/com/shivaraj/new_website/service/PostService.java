package com.shivaraj.new_website.service;

import com.shivaraj.new_website.models.Post;

import java.util.List;

public interface PostService {
    Post createNewPost(Post post, Integer id) throws Exception;
    String deletePost(Integer postId, Integer id) throws Exception;
    List<Post> findPostByUserId(Integer id);
    Post findPostById(Integer postId) throws Exception;
    List<Post> findAllPost();
    Post savedPost(Integer postId, Integer id) throws Exception;
    Post likePost(Integer postId,Integer id) throws Exception;
}
