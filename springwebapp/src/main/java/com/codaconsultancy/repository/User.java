package com.codaconsultancy.repository;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String firstName;
    private Integer age;
    private List<Post> posts = new ArrayList<Post>();

    public User(String firstName, Integer age) {
        this.firstName = firstName;
        this.age = age;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
