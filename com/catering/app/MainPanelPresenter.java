package com.catering.app;

import com.catering.view.form.LoginForm;
import com.catering.view.form.RegisterForm;
import com.catering.view.menu.SidebarMenu;
import com.catering.view.manager.FormsManager;
import com.catering.view.menu.ContentMenu;

public class MainPanelPresenter {

    private final MainPanel mainPanel;
    private final LoginForm loginForm;
    private final RegisterForm registerForm;

    public MainPanelPresenter(MainPanel mainPanel, LoginForm loginForm, RegisterForm registerForm, ContentMenu contentMenu) {
        this.mainPanel = mainPanel;
        this.loginForm = loginForm;
        this.registerForm = registerForm;
    }

    public void showLoginForm() {
        FormsManager.getInstance().showForm(loginForm);
    }

    public void showRegisterForm() {
        FormsManager.getInstance().showForm(registerForm);
    }

    public void showContentMenu() {
        FormsManager.getInstance().showMenu(new SidebarMenu());
    }
}
