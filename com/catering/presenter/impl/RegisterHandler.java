package com.catering.presenter.impl;

import com.catering.model.service.UserService;
import com.catering.presenter.RegisterPresenter;
import com.catering.view.RegisterView;

public class RegisterHandler implements RegisterPresenter{
    
    private final com.catering.view.RegisterView registerView;
    private final com.catering.model.service.UserService userService;
    
    public RegisterHandler(RegisterView registerView, UserService userService) {
        this.registerView = registerView;
        this.userService = userService;
    }
    
    @Override
    public void textLoginClicked() {
        
        com.catering.view.manager.FormsManager.getInstance().showForm(new com.catering.view.form.LoginForm());
        
    }
}
