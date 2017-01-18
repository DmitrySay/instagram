package com.ranga.service;

import com.ranga.entities.User;

public interface UserService {

    User findByUsername(String username);
    User save(User user);


}
