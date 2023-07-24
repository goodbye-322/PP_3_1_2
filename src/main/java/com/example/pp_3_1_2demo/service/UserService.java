package com.example.pp_3_1_2demo.service;


import com.example.pp_3_1_2demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void createUser(User user);

    void updateUser(User user,long id);

    void deleteUserById(Long id);

}
