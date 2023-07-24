package com.example.pp_3_1_2demo.dao;


import com.example.pp_3_1_2demo.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }


    @Transactional
    @Override
    public void updateUser(User user, long id) {
        User userToBeUpdate = entityManager.find(User.class, id);
        userToBeUpdate.setName(user.getName());
        userToBeUpdate.setLastName(user.getLastName());
        userToBeUpdate.setAge(user.getAge());
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
