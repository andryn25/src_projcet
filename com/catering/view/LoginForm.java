package com.catering.view;

public interface LoginForm {

    String getUsername();

    char[] getPassword();

    void showLoginFailedMessage();

    void showEmptyUsernameMessage();

    void showEmptyPasswordMessage();

    void hideAllMessages();

    void setPasswordVisible(boolean visible);

    boolean isShowPasswordChecked();

    boolean isPasswordPlaceholderVisible();

}
