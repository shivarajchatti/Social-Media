package com.shivaraj.new_website.service;

import com.shivaraj.new_website.models.User;

import java.util.List;

public interface UserService {
    public User registerUser(User user);

    public User findUserById(Integer id) throws Exception;

    public User findUserByEmail(String email);

    public User followUser(Integer id1, Integer id2) throws Exception;

    public User  updateUser(User user,Integer id) throws Exception;

    public List<User> searchUser(String query);
}
