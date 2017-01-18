package com.ranga.service;

import com.ranga.dao.UserDao;
import com.ranga.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;


    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
