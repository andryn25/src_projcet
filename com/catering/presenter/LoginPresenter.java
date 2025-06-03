package com.catering.presenter;


import com.catering.model.User;
import com.catering.app.MainPanelPresenter;
import com.catering.util.Console;
import com.catering.view.form.LoginForm;
import com.catering.view.menu.SidebarMenu;
import com.catering.view.manager.FormsManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPresenter {
    private final Connection connection;
    private final LoginForm loginForm;
    private final MainPanelPresenter mainPanelPresenter;
    
    public LoginPresenter(LoginForm loginForm, MainPanelPresenter mainPanelPresenter, Connection connection) {
        this.loginForm = loginForm;
        this.mainPanelPresenter = mainPanelPresenter;
        this.connection = connection;
    }

    public void btnLoginClicked() {
        
        String username = loginForm.getUsername();
        char[] password = loginForm.getPassword();

        if (username.isEmpty() || loginForm.isUsernamePlaceholderVisible()) {
            loginForm.showEmptyUsernameMessage();
            return;
        }

        if (password.length == 0 || loginForm.isPasswordPlaceholderVisible()) {
            loginForm.showEmptyPasswordMessage();
            return;
        }

        // UserJDBC "ambil data nama dan password user"
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        User user;
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                user = new User();
                user.setNama(resultSet.getString("nama"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // User Service "cek user"
        for (User u : users) {
            
            if (u.getNama().equals(username) && Arrays.equals(u.getPassword().toCharArray(), password)) {

                // cek role user (admin atau customer)
                if (u != null && "admin".equalsIgnoreCase(u.getRole())) {
                    com.catering.util.Console.logInfo("Admin baru saja login");
                    FormsManager.getInstance().showMenu(new SidebarMenu());
                } else if (u != null && "customer".equalsIgnoreCase(u.getRole())) {
                    com.catering.util.Console.logInfo("Customer baru saja login");
                    FormsManager.getInstance().showMenu(new SidebarMenu());
                }
                loginForm.hideAllMessages();
                return;
            }
        
        }
        loginForm.showLoginFailedMessage();
        
    }
    
    public void textRegisterClicked() {
        mainPanelPresenter.showRegisterForm();

    }

    public void showHidePassword() {
        if (!loginForm.isPasswordPlaceholderVisible()) {
            loginForm.setPasswordVisible(loginForm.isShowPasswordChecked());
        }

    }

    public void usernameTextFieldFocusGained() {
        if (loginForm.isUsernamePlaceholderVisible()) {
            loginForm.removeUsernameTextFieldPlaceholder();
        }
    }

    public void usernameTextFieldFocusLost() {
        if (loginForm.isUsernameEmpty()) {
            loginForm.addUsernameTextFieldPlaceholder();
        }
    }

    public void passwordFieldFocusGained() {

        if (loginForm.isPasswordPlaceholderVisible()) {
            loginForm.removePasswordFieldPlaceholder();
        }
        showHidePassword();
    }

    public void passwordFieldFocusLost() {
        if (loginForm.isPasswordEmpty()) {
            loginForm.addPasswordFieldPlaceholder();
        }
        showHidePassword();

    }

}
