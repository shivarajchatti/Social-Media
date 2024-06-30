package com.shivaraj.new_website.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity  //To create Table in database
@Table(name="users") //To change name of table other than class else class name is default table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // @Column(name="first_name"): we can change column name else default camel case
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Integer> followers =new ArrayList<>();
    private List<Integer> followings =new ArrayList<>();
    private List<Post> savedPost=new ArrayList<>();
    private String gender;
  public User(Integer id, String firstName, String lastName, String email, String password){
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
}

    public User(Integer id, String firstName, String lastName, String email, String password, List<Integer> followers, List<Integer> followings, List<Post> savedPost, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.followers = followers;
        this.followings = followings;
        this.savedPost = savedPost;
        this.gender = gender;
    }

    public List<Post> getSavedPost() {
        return savedPost;
    }

    public void setSavedPost(List<Post> savedPost) {
        this.savedPost = savedPost;
    }

    public User(){

}

    public User(Integer id, String firstName, String lastName, String email, String password, List<Integer> followers, List<Integer> followings, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.followers = followers;
        this.followings = followings;
        this.gender = gender;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Integer> followings) {
        this.followings = followings;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
