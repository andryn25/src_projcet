package com.catering.model.service.impl;

import com.catering.model.User;
import com.catering.model.dao.UserDao;
import com.catering.model.service.UserService;
import java.util.List;

class UserServiceJdbc implements UserService {

    private final UserDao userDao;

    public UserServiceJdbc(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String nama, String password) {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            if (user.getNama().equals(nama) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User register(String nama, String password,
            String email) {
        User newUser = new User();
        newUser.setNama(nama);
        newUser.setPassword(password);
        newUser.setEmail(email);
        if (userDao.getUserByNama(nama) != null) {
            return null;
        } else if (userDao.getUserByEmail(email) != null) {
            return null;
        }
        newUser.setRole("customer");
        userDao.insertUser(newUser);
        return newUser;
    }

    @Override
    public boolean cekAdmin(User user) {
        return user != null && "admin".equalsIgnoreCase(user.getRole());
    }

    @Override
    public boolean cekCustomer(User user) {
        return user != null && "customer".equalsIgnoreCase(user.getRole());
    }

}
