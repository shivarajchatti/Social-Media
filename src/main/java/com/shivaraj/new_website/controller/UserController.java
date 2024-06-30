package com.shivaraj.new_website.controller;

import com.shivaraj.new_website.models.User;
import com.shivaraj.new_website.repository.UserRepository;
import com.shivaraj.new_website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user ){
        return userService.registerUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) throws Exception {

      return userService.updateUser(user,id);

    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users=userRepository.findAll(); // To find all users from users table
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer id) throws Exception {
        return userService.findUserById(id);
        }

        @PutMapping("/users/follow/{id1}/{id2}")
        public User followUserHandler(@PathVariable Integer id1,@PathVariable Integer id2) throws Exception {
        User user=userService.followUser(id1,id2);
        return user;
        }

        @DeleteMapping("/users/{id}")
        public String deleteUser(@PathVariable Integer id) throws Exception {
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new Exception("user is not exist with userId: "+id);
        }
        userRepository.deleteById(id);
        return"User is deleted with Id: "+id;
        }
        @GetMapping("/users/search")
       public List<User> searchUser(@RequestParam("query")String query){
        List<User> users=userService.searchUser(query);
        return users;
       }

}