package com.catering.presenter;

import com.catering.app.MainPanelPresenter;
import com.catering.view.form.RegisterForm;
import java.sql.Connection;

public class RegisterPresenter {

    private final RegisterForm registerForm;
    private final Connection connection;
    private final MainPanelPresenter mainPanelPresenter;

    public RegisterPresenter(RegisterForm registerView, MainPanelPresenter mainPanelPresenter, Connection connection) {
        this.registerForm = registerView;
        this.mainPanelPresenter = mainPanelPresenter;
        this.connection = connection;
    }

    public void textLoginClicked() {
        mainPanelPresenter.showLoginForm();
    }

    public void showHidePassword() {
        boolean visible = registerForm.isShowPasswordChecked();
        
        if (!registerForm.isPasswordPlaceholderVisible()) {
            registerForm.setPasswordVisible(visible);
        }
        
        if (!registerForm.isConfirmPasswordPlaceholderVisible()) {
            registerForm.setConfirmPasswordVisible(visible);
        }
    }

    public void usernameTextFieldFocusGained() {
        if (registerForm.isUsernamePlaceholderVisible()) {
            registerForm.removeUsernameTextFieldPlaceholder();
        }
    }

    public void usernameTextFieldFocusLost() {
        if (registerForm.isUsernameEmpty()) {
            registerForm.addUsernameTextFieldPlaceholder();
        }
    }

    public void emailTextFieldFocusGained() {
        if (registerForm.isEmailPlaceholderVisible()) {
            registerForm.removeEmailTextFieldPlaceholder();
        }
    }

    public void emailTextFieldFocusLost() {
        if (registerForm.isEmailEmpty()) {
            registerForm.addEmailTextFieldPlaceholder();
        }
    }

    public void passwordFieldFocusGained() {

        if (registerForm.isPasswordPlaceholderVisible()) {
            registerForm.removePasswordFieldPlaceholder();
        }
        showHidePassword();
    }

    public void passwordFieldFocusLost() {
        if (registerForm.isPasswordEmpty()) {
            registerForm.addPasswordFieldPlaceholder();
        }
        showHidePassword();

    }

    public void confirmPasswordFieldFocusGained() {
        if (registerForm.isConfirmPasswordPlaceholderVisible()) {
            registerForm.removeConfirmPasswordFieldPlaceholder();
        }
        showHidePassword();
    }

    public void confirmPasswordFieldFocusLost() {
        if (registerForm.isConfirmPasswordEmpty()) {
            registerForm.addConfirmPasswordFieldPlaceholder();
        }
        showHidePassword();
    }

}
