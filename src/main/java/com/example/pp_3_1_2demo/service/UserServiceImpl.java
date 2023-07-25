package com.example.pp_3_1_2demo.service;


import com.example.pp_3_1_2demo.dao.UserDao;
import com.example.pp_3_1_2demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional()
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }


    @Transactional
    @Override
    public void updateUser(User user, long id) {
        userDao.updateUser(user, id);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
