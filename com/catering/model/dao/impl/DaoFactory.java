package com.catering.model.dao.impl;

import com.catering.model.dao.UserDao;
import java.sql.Connection;

public class DaoFactory {

    private final Connection connection;

    public DaoFactory(Connection connection) {
        this.connection = connection;
    }

    public UserDao createUserDao() {
        return new UserJdbc(connection);
    }
}
