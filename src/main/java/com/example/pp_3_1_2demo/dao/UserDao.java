package com.example.pp_3_1_2demo.dao;


import com.example.pp_3_1_2demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();

    void createUser(User user);

    void updateUser(User user, long id);

    void deleteUserById(Long id);
}
