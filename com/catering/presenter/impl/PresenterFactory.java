
package com.catering.presenter.impl;

import com.catering.model.service.impl.ServiceFactory;
import com.catering.presenter.LoginPresenter;
import com.catering.view.LoginForm;

public class PresenterFactory {
    private final ServiceFactory serviceFactory;
    
    public PresenterFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }
    
    public LoginPresenter createLoginPresenter(LoginForm loginView) {
        return new LoginPresenterImpl(loginView, serviceFactory.createUserService());
    }
}
