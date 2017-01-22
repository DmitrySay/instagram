package com.ranga.dao;

import com.ranga.entities.User;


public interface UserDao {

    User findByUsername(String username);

    void save(User user);
}
