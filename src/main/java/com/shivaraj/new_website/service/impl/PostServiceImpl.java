package com.shivaraj.new_website.service.impl;

import com.shivaraj.new_website.models.Post;
import com.shivaraj.new_website.models.User;
import com.shivaraj.new_website.repository.PostRepository;
import com.shivaraj.new_website.repository.UserRepository;
import com.shivaraj.new_website.service.PostService;
import com.shivaraj.new_website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public Post createNewPost(Post post, Integer id) throws Exception {
        User user=userService.findUserById(id);
        Post newPost=new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setCreatedTs(LocalDateTime.now() );
        newPost.setVideo(post.getVideo());
        newPost.setUser(user);
        return newPost;
    }

    @Override
    public String deletePost(Integer postId, Integer id) throws Exception {
        Post post=findPostById(postId);
        User user=userService.findUserById(id);
        if((post.getUser().getId())!=user.getId()){
            throw new Exception("You Cant delete Others Post");
        }
        postRepository.delete(post);
        return "Post Deleted Successfully";
    }

    @Override
    public List<Post> findPostByUserId(Integer id) {
        return postRepository.findPostByUserId(id);
    }

    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post> post=postRepository.findById(postId);
        if(post.isEmpty()){
            throw new Exception("Post doesnt exist wit postId: "+postId);
        }
        return post.get();
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post savedPost(Integer postId, Integer id) throws Exception {
        Post post=findPostById(postId);
        User user=userService.findUserById(id);
        if(user.getSavedPost().contains(post)){
            user.getSavedPost().remove(post);
        }
        else{
            user.getSavedPost().add(post);
        }
        userRepository.save(user);
        return post;
    }

    @Override
    public Post likePost(Integer postId, Integer id) throws Exception {
        Post post=findPostById(postId);
        User user=userService.findUserById(id);
        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }
        else{
        post.getLiked().add(user);}
        return postRepository.save(post);
    }
}
