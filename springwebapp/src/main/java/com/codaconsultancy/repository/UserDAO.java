package com.codaconsultancy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findById(Long id) {
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    public List<User> findAll() {
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new UserMapper());
        return userList;
    }

    public void add(User user) {
        String sql = "insert into user (first_name, age) values (?, ?)";
        System.out.println("Adding user " + user.getFirstName() + " aged " + user.getAge());
        jdbcTemplate.update(sql, user.getFirstName(), user.getAge());
    }

    private class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet row, int rowNum) throws SQLException {
            User user = new User();

            user.setId(row.getLong("id"));
            user.setFirstName(row.getString("first_name"));
            user.setAge(row.getInt("age"));

            return user;
        }
    }
}
