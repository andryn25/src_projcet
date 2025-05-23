package com.catering.presenter.impl;

public class RegisterHandler {
    
    private com.catering.view.RegisterView registerView;
    private com.catering.model.service.UserService userService;
    
    public RegisterHandler(com.catering.view.RegisterView registerView, com.catering.model.service.UserService userService) {
        this.registerView = registerView;
        this.userService = userService;
    }
    
    public void onLoginClicked() {
        
        com.catering.view.manager.FormsManager.getInstance().showForm(new com.catering.view.impl.LoginForm());
        
    }
}
