package ru.zichead.PP_3_1_2.web.dao;

import ru.zichead.PP_3_1_2.web.model.User;

import java.util.List;

public interface UserDAO {

    void add(User user);

    User findUserToID(Long id);

    void deleteUser (Long id);

     void updateUser (User user);
     List<User> getUserList();
}
