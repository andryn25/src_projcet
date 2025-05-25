package com.catering.presenter.impl;

import com.catering.model.service.impl.ServiceFactory;
import com.catering.presenter.LoginPresenter;
import com.catering.presenter.MainPanelPresenter;
import com.catering.presenter.RegisterPresenter;
import com.catering.view.LoginView;
import com.catering.view.MainPanelView;
import com.catering.view.RegisterView;
import java.sql.Connection;

public class PresenterFactory {

    public LoginPresenter createLoginPresenter(LoginView loginView, Connection connection) {
        ServiceFactory serviceFactory = new ServiceFactory(connection);
        return new LoginHandler(loginView, serviceFactory.createUserService());
    }

    public MainPanelPresenter createMainPanelPresenter(MainPanelView mainPanelView) {
        return new MainPanelHandler(mainPanelView);
    }
    
    public RegisterPresenter createrRegisterPresenter(RegisterView registerView, Connection connection) {
        ServiceFactory serviceFactory = new ServiceFactory(connection);
        return new RegisterHandler(registerView, serviceFactory.createUserService());
    }
}
