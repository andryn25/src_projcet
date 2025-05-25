package com.catering.view;

public interface LoginView {

    String getUsername();

    char[] getPassword();

    void showLoginFailedMessage();

    void showEmptyUsernameMessage();

    void showEmptyPasswordMessage();

    void hideAllMessages();

    void setPasswordVisible(boolean visible);

    boolean isShowPasswordChecked();

    boolean isPasswordPlaceholderVisible();
    
    boolean isUsernamePlaceholderVisible();
    
    boolean isUsernameEmpty();
    
    boolean isPasswordEmpty();
    
    void removeUsernameTextFieldPlaceholder();
    
    void removePasswordFieldPlaceholder();
    
    void addUsernameTextFieldPlaceholder();
    
    void addPasswordFieldPlaceholder();

}
