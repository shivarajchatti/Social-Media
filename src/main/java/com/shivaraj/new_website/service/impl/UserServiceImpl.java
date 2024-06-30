package com.shivaraj.new_website.service.impl;

import com.shivaraj.new_website.models.User;
import com.shivaraj.new_website.repository.UserRepository;
import com.shivaraj.new_website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        User newUser=new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        User savedUser=userRepository.save(newUser);
        return savedUser;
    }

    @Override
    public User findUserById(Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("User not exist wit id: "+id);
    }

    @Override
    public User findUserByEmail(String email) {
       User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User followUser(Integer id1, Integer id2) throws Exception {
        User user1=findUserById(id1);
        User user2=findUserById(id2);
        user2.getFollowers().add(user1.getId());
        user1.getFollowings().add(user2.getId());
        userRepository.save(user1);
        userRepository.save(user2);
        return user1;
    }

    @Override
    public User updateUser(User user,Integer id) throws Exception {
        Optional<User> user1=userRepository.findById(id);
        if(user1.isEmpty()){
            throw new Exception("user is not exist wit id: "+id);
        }
        User oldUser=user1.get();
        if(user.getFirstName()!=null){
            oldUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            oldUser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            oldUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            oldUser.setPassword(user.getPassword());
        }
        User updatedUser=userRepository.save(oldUser);
        return updatedUser;
    }

    @Override
    public List<User> searchUser(String query) {
        List<User> users=userRepository.searchUser(query);
        return users;
    }
}
