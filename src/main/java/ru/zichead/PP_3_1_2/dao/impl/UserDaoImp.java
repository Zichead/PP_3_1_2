package ru.zichead.PP_3_1_2.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zichead.PP_3_1_2.dao.UserDAO;
import ru.zichead.PP_3_1_2.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserToID(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
       User user = findUserToID(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }
}
