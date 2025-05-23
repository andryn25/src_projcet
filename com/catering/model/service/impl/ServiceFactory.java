
package com.catering.model.service.impl;

import com.catering.model.dao.impl.DaoFactory;
import com.catering.model.service.UserService;
import java.sql.Connection;

public class ServiceFactory {
    private final Connection connection;
    
    public ServiceFactory(Connection connection) {
        this.connection = connection;
    }
    
    public UserService createUserService() {
        DaoFactory daoFactory = new DaoFactory(connection);
        return new UserServiceImpl(daoFactory.createUserDao());
    }
    
}
