package com.catering.view.form;

import com.catering.presenter.LoginPresenter;

import java.awt.Color;
import java.awt.Font;
//import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;

public final class LoginForm extends javax.swing.JPanel {

    private LoginPresenter loginPresenter;

    public LoginForm() {
        initComponents();
        setOpaque(false);
        pfPassword.setEchoChar('\u0000');
        lbWarning.setVisible(false);
        addPlaceholderStyle(tfUsername);
        addPlaceholderStyle(pfPassword);
    }

    public void setPresenter(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    public String getUsername() {
        return tfUsername.getText();
    }

    public char[] getPassword() {
        return pfPassword.getPassword();

    }

    public void showEmptyPasswordMessage() {
        lbWarning.setText("Silahkan masukkan kata sandi kamu.");
        lbWarning.setVisible(true);
    }

    public void hideAllMessages() {
        lbWarning.setVisible(false);
    }

    public void showEmptyUsernameMessage() {
        lbWarning.setText("Silahkan masukkan username kamu.");
        lbWarning.setVisible(true);
    }

    public boolean isShowPasswordChecked() {
        return cbShowPassword.isSelected();
    }

    public void showLoginFailedMessage() {
        lbWarning.setText("Username atau kata sandi salah.");
        lbWarning.setVisible(true);
    }

    public void setPasswordVisible(boolean visible) {
        char echoChar = (visible) ? ((char) 0) : '•' ;
        pfPassword.setEchoChar(echoChar);
    }

    public boolean isPasswordPlaceholderVisible() {
        return new String(getPassword()).equals("Masukan kata sandi");
    }

    public boolean isUsernamePlaceholderVisible() {
        return getUsername().equals("Masukan username");
    }

    public void addPlaceholderStyle(JTextField tf) {
        Font font = tf.getFont();
        font = font.deriveFont(Font.ITALIC);
        tf.setFont(font);
    }

    public void removePlaceholderStyle(JTextField tf) {
        Font font = tf.getFont();
        font = font.deriveFont(Font.PLAIN);
        tf.setFont(font);
    }

    public void removeUsernameTextFieldPlaceholder() {
        tfUsername.setText("");
        tfUsername.requestFocus();
        removePlaceholderStyle(tfUsername);
    }

    public void removePasswordFieldPlaceholder() {
        pfPassword.setText("");
        pfPassword.requestFocus();
        removePlaceholderStyle(pfPassword);
    }

    public void addUsernameTextFieldPlaceholder() {
        addPlaceholderStyle(tfUsername);
        tfUsername.setText("Masukan username");
    }

    public boolean isUsernameEmpty() {
        return getUsername().trim().isEmpty();
    }

    public boolean isPasswordEmpty() {
        return new String(getPassword()).isEmpty();
    }

    public void addPasswordFieldPlaceholder() {
        addPlaceholderStyle(pfPassword);
        pfPassword.setText("Masukan kata sandi");
        pfPassword.setEchoChar((char) 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //GradientPaint gp = new GradientPaint(0, 0, Color.decode("#abbaab"), 0, getHeight(), Color.decode("#abbaab"));
        //g2.setPaint(gp);
        g2.setColor(new Color(255, 255, 255, 100));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
        g2.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbGreeting = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        lbWarning = new javax.swing.JLabel();
        cbShowPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        lbInstruction = new javax.swing.JLabel();
        cbRemember = new javax.swing.JCheckBox();
        logo = new javax.swing.JLabel();
        subPanel1 = new javax.swing.JPanel();
        lbSignInInfo = new javax.swing.JLabel();
        lbLinkSignIn = new javax.swing.JLabel();
        lbLinkForgetPassword = new javax.swing.JLabel();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        lbGreeting.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        lbGreeting.setText("Hai, Kamu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 5, 0);
        add(lbGreeting, gridBagConstraints);

        lbUsername.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUsername.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbUsername, gridBagConstraints);

        tfUsername.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        tfUsername.setText("Masukan username");
        tfUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUsernameFocusLost(evt);
            }
        });
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(tfUsername, gridBagConstraints);

        lbPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPassword.setText("Kata sandi");
        lbPassword.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbPassword, gridBagConstraints);

        pfPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        pfPassword.setText("Masukan kata sandi");
        pfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pfPasswordFocusLost(evt);
            }
        });
        pfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(pfPassword, gridBagConstraints);

        lbWarning.setFont(new java.awt.Font("Nunito", 2, 12)); // NOI18N
        lbWarning.setForeground(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 10, 0);
        add(lbWarning, gridBagConstraints);

        cbShowPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        cbShowPassword.setText("Tampilkan kata sandi");
        cbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 0, 0);
        add(cbShowPassword, gridBagConstraints);

        btnLogin.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnLogin.setText("Masuk");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(btnLogin, gridBagConstraints);

        lbInstruction.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        lbInstruction.setText("Masukan username dan password untuk masuk");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 20, 35);
        add(lbInstruction, gridBagConstraints);

        cbRemember.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        cbRemember.setText("Jangan lupain aku:(");
        cbRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRememberActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 20, 0);
        add(cbRemember, gridBagConstraints);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/logo_home.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 35);
        add(logo, gridBagConstraints);

        subPanel1.setBackground(new Color(0,0,0,0));

        lbSignInInfo.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbSignInInfo.setText("Belum punya akun ya?");
        subPanel1.add(lbSignInInfo);

        lbLinkSignIn.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbLinkSignIn.setForeground(new java.awt.Color(102, 102, 255));
        lbLinkSignIn.setText("<html> <a href='#' style='color: blue;'>Daftar yuk</a></html>");
        lbLinkSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLinkSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLinkSignInMouseClicked(evt);
            }
        });
        subPanel1.add(lbLinkSignIn);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 0, 35);
        add(subPanel1, gridBagConstraints);

        lbLinkForgetPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbLinkForgetPassword.setForeground(new java.awt.Color(102, 102, 255));
        lbLinkForgetPassword.setText("<html> <a href='#' style='color: blue;'>Lupa Sandi?</a></html>");
        lbLinkForgetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLinkForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLinkForgetPasswordMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 35, 35);
        add(lbLinkForgetPassword, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void pfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPasswordActionPerformed
        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_pfPasswordActionPerformed

    private void cbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPasswordActionPerformed
        loginPresenter.showHidePassword();
    }//GEN-LAST:event_cbShowPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        loginPresenter.btnLoginClicked();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        pfPassword.requestFocus();
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void cbRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRememberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRememberActionPerformed

    private void tfUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsernameFocusGained
        tfUsername.selectAll();
        loginPresenter.usernameTextFieldFocusGained();
    }//GEN-LAST:event_tfUsernameFocusGained

    private void pfPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfPasswordFocusGained
        pfPassword.selectAll();
        loginPresenter.passwordFieldFocusGained();
        
    }//GEN-LAST:event_pfPasswordFocusGained

    private void tfUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsernameFocusLost
        loginPresenter.usernameTextFieldFocusLost();
        tfUsername.select(0, 0);
    }//GEN-LAST:event_tfUsernameFocusLost

    private void pfPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfPasswordFocusLost
        loginPresenter.passwordFieldFocusLost();
        pfPassword.select(0, 0);
    }//GEN-LAST:event_pfPasswordFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void lbLinkSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinkSignInMouseClicked
        loginPresenter.textRegisterClicked();
    }//GEN-LAST:event_lbLinkSignInMouseClicked

    private void lbLinkForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinkForgetPasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbLinkForgetPasswordMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cbRemember;
    private javax.swing.JCheckBox cbShowPassword;
    private javax.swing.JLabel lbGreeting;
    private javax.swing.JLabel lbInstruction;
    private javax.swing.JLabel lbLinkForgetPassword;
    private javax.swing.JLabel lbLinkSignIn;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbSignInInfo;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JPanel subPanel1;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

}
