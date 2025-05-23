package com.catering.view;

public interface RegisterForm {

    String getNama();

    String getEmail();

    char[] getPassword();
    
    char[] getConfirmPassword();
    
    void showSignUpFailedMessage();

    void showEmptyUsernameMessage();
    
    void showEmptyEmailMessage();

    void showEmptyPasswordMessage();
    
    void showEmptyConfirmPasswordMessage();

    void hideAllMessages();

    void setPasswordVisible(boolean visible);

    boolean isShowPasswordChecked();

    boolean isPasswordPlaceholderVisible();
    
}
