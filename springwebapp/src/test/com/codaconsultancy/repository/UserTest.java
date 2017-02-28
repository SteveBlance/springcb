package com.codaconsultancy.repository;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserTest {
    @Test
    public void getId() {
        User user = new User("Bob", 25);
        assertNull(user.getId());
        Long id = 345L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void getFirstName() {
        User user = new User("Bob", 25);
        assertEquals("Bob", user.getFirstName());
        user.setFirstName("Dave");
        assertEquals("Dave", user.getFirstName());
    }

    @Test
    public void getAge() {
        User user = new User("Bob", 44);
        assertEquals(44, user.getAge().intValue());
        user.setAge(45);
        assertEquals(45, user.getAge().intValue());
    }

    @Test
    public void getPosts() {
        Post post1 = new Post("Post 1");
        Post post2 = new Post("Post 2");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        User user = new User("Bob", 44);
        user.setPosts(posts);
        assertEquals(2, user.getPosts().size());
        assertEquals("Post 1", user.getPosts().get(0).getTitle());
        assertEquals("Post 2", user.getPosts().get(1).getTitle());
    }


}