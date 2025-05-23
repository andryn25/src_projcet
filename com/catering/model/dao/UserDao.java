package com.catering.model.dao;

import com.catering.model.User;
import java.util.List;

public interface UserDao {

    User getUserById(int id);

    User getUserByNama(String nama);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
