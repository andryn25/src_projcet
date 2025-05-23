package com.catering.presenter.impl;

import com.catering.model.service.impl.ServiceFactory;
import com.catering.presenter.LoginPresenter;
import com.catering.presenter.MainPanelPresenter;
import com.catering.view.LoginView;
import com.catering.view.MainPanelView;
import java.sql.Connection;

public class PresenterFactory {

    private ServiceFactory serviceFactory;

    public LoginPresenter createLoginPresenter(LoginView loginView, Connection connection) {
        serviceFactory = new ServiceFactory(connection);
        return new LoginHandler(loginView, serviceFactory.createUserService());
    }

    public MainPanelPresenter createMainPanelPresenter(MainPanelView mainPanelView) {
        return new MainPanelHandler(mainPanelView);
    }
}
