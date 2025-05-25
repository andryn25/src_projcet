package com.catering.presenter.impl;

// Presenter mengakses MODEL
import com.catering.model.User;
import com.catering.model.service.UserService;
import com.catering.presenter.LoginPresenter;
// Presenter mengakses VIEW
import com.catering.view.LoginView;
import com.catering.view.form.RegisterForm;
import com.catering.view.menu.SidebarMenu;
import com.catering.view.manager.FormsManager;

class LoginHandler implements LoginPresenter {

    private final com.catering.view.LoginView loginView;
    private final com.catering.model.service.UserService userService;

    public LoginHandler(LoginView loginView, UserService userService) {
        this.loginView = loginView;
        this.userService = userService;
    }

    @Override
    public void btnLoginClicked() {

        String username = loginView.getUsername();
        String password = new String(loginView.getPassword());

        if (username.isEmpty()) {
            loginView.showEmptyUsernameMessage();
            return;
        }

        if (password.isEmpty()) {
            loginView.showEmptyPasswordMessage();
            return;
        }

        User user = userService.login(username, password);

        if (user == null) {
            loginView.showLoginFailedMessage();
            return;
        }

        loginView.hideAllMessages();

        if (userService.cekAdmin(user)) {
            com.catering.util.Console.logInfo("Admin baru saja login");
            FormsManager.getInstance().showMenu(new SidebarMenu());
        } else if (userService.cekCustomer(user)) {
            com.catering.util.Console.logInfo("Customer baru saja login");
            FormsManager.getInstance().showMenu(new SidebarMenu());
        } else {
            com.catering.util.Console.logWarning("User login tidak dikenali");
        }
    }

    @Override
    public void textRegisterClicked() {
        FormsManager.getInstance().showForm(new RegisterForm());
    }

    @Override
    public void showHidePassword() {
        loginView.setPasswordVisible(loginView.isShowPasswordChecked());
    }

    @Override
    public void usernameTextFieldFocusGained() {
        if (loginView.isUsernamePlaceholderVisible()) {
            loginView.removeUsernameTextFieldPlaceholder();
        }
    }

    @Override
    public void usernameTextFieldFocusLost() {
        if (loginView.isUsernameEmpty()) {
            loginView.addUsernameTextFieldPlaceholder();
        }
    }

    @Override
    public void passwordFieldFocusGained() {
        
    }

    @Override
    public void passwordFieldFocusLost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
