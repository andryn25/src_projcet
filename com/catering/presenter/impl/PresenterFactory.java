
package com.catering.presenter.impl;

import com.catering.model.service.impl.ServiceFactory;
import com.catering.presenter.LoginPresenter;
import com.catering.view.LoginView;

public class PresenterFactory {
    private final ServiceFactory serviceFactory;
    
    public PresenterFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }
    
    public LoginPresenter createLoginPresenter(LoginView loginView) {
        return new LoginHandler(loginView, serviceFactory.createUserService());
    }
}
