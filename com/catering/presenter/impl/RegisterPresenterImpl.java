package com.catering.presenter.impl;

public class RegisterPresenterImpl {
    
    private com.catering.view.RegisterForm registerView;
    private com.catering.model.service.UserService userService;
    
    public RegisterPresenterImpl(com.catering.view.RegisterForm registerView, com.catering.model.service.UserService userService) {
        this.registerView = registerView;
        this.userService = userService;
    }
    
    public void onLoginClicked() {
        
        com.catering.view.manager.FormsManager.getInstance().showForm(new com.catering.view.impl.LoginFormImpl());
        
    }
}
