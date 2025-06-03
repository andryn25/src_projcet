package com.catering.view.form;

import com.catering.presenter.RegisterPresenter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public final class RegisterForm extends javax.swing.JPanel {
    
    private RegisterPresenter registerPresenter;
    
    public RegisterForm() {
        
        initComponents();
        setOpaque(false);
        pfPassword.setEchoChar('\u0000');
        pfConfirmPassword.setEchoChar('\u0000');
        pfConfirmPassword.setEnabled(false);
        pfPassword.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent de) {
                checkPasswordInput();
            }
            
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent de) {
                checkPasswordInput();
            }
            
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent de) {
                checkPasswordInput();
            }
        });
        addPlaceholderStyle(tfUsername);
        addPlaceholderStyle(tfEmail);
        addPlaceholderStyle(pfPassword);
        addPlaceholderStyle(pfConfirmPassword);
        
    }
    
    public void setPresenter(RegisterPresenter registerPresenter) {
        this.registerPresenter = registerPresenter;
    }
    
    public void addPlaceholderStyle(javax.swing.JTextField tf) {
        java.awt.Font font = tf.getFont();
        font = font.deriveFont(java.awt.Font.ITALIC);
        tf.setFont(font);
    }
    
    public void removePlaceholderStyle(javax.swing.JTextField tf) {
        java.awt.Font font = tf.getFont();
        font = font.deriveFont(java.awt.Font.PLAIN);
        tf.setFont(font);
    }
    
    public String getUsername() {
        return tfUsername.getText();
    }
    
    public String getEmail() {
        return tfEmail.getText();
    }
    
    public char[] getPassword() {
        return pfPassword.getPassword();
    }
    
    public char[] getConfirmPassword() {
        return pfConfirmPassword.getPassword();
    }
    
    public void addUsernameTextFieldPlaceholder() {
        addPlaceholderStyle(tfUsername);
        tfUsername.setText("Masukan username");
    }
    
    public void addPasswordFieldPlaceholder() {
        addPlaceholderStyle(pfPassword);
        pfPassword.setText("Masukan kata sandi");
        pfPassword.setEchoChar((char) 0);
    }
    
    public boolean isUsernameEmpty() {
        return getUsername().trim().isEmpty();
    }
    
    public boolean isPasswordEmpty() {
        return new String(getPassword()).isEmpty();
    }
    
    public boolean isConfirmPasswordEmpty() {
        return new String(getConfirmPassword()).isEmpty();
    }
    
    public void showSignUpFailedMessage() {
        lbWarning.setText("Username atau kata sandi sudah terdaftar.");
        lbWarning.setVisible(true);
    }
    
    public void showEmptyUsernameMessage() {
        lbWarning.setText("Silahkan masukkan username kamu.");
        lbWarning.setVisible(true);
    }
    
    public void showEmptyPasswordMessage() {
        lbWarning.setText("Silahkan masukkan kata sandi kamu.");
        lbWarning.setVisible(true);
    }
    
    public void hideAllMessages() {
        lbWarning.setVisible(false);
    }
    
    public void setPasswordVisible(boolean visible) {
        char echoChar = (visible) ? ((char) 0) : '•';
        pfPassword.setEchoChar(echoChar);
    }
    
    public void setConfirmPasswordVisible(boolean visible) {
        char echoChar = (visible) ? ((char) 0) : '•';
        pfConfirmPassword.setEchoChar(echoChar);
    }
    
    public boolean isShowPasswordChecked() {
        return cbShowPassword.isSelected();
    }
    
    public boolean isUsernamePlaceholderVisible() {
        return getUsername().equals("Masukan username");
    }
    
    public boolean isEmailPlaceholderVisible() {
        return getEmail().equals("Masukan email");
    }
    
    public boolean isPasswordPlaceholderVisible() {
        return new String(getPassword()).equals("Masukan kata sandi");
    }
    
    public boolean isConfirmPasswordPlaceholderVisible() {
        return new String(getConfirmPassword()).equals("Konfirmasi kata sandi");
    }
    
    public void showEmptyEmailMessage() {
        lbWarning.setText("Silahkan masukkan email kamu.");
        lbWarning.setVisible(true);
    }
    
    public void showEmptyConfirmPasswordMessage() {
        lbWarning.setText("Silahkan masukkan konfirmasi kata sandi kamu.");
        lbWarning.setVisible(true);
    }
    
    public void removeUsernameTextFieldPlaceholder() {
        tfUsername.setText("");
        tfUsername.requestFocus();
        removePlaceholderStyle(tfUsername);
    }
    
    public void removeEmailTextFieldPlaceholder() {
        tfEmail.setText("");
        tfEmail.requestFocus();
        removePlaceholderStyle(tfEmail);
    }
    
    public void removePasswordFieldPlaceholder() {
        pfPassword.setText("");
        pfPassword.requestFocus();
        removePlaceholderStyle(pfPassword);
    }
    
    public void removeConfirmPasswordFieldPlaceholder() {
        pfConfirmPassword.setText("");
        pfConfirmPassword.requestFocus();
        removePlaceholderStyle(pfConfirmPassword);
    }
    
    public boolean isEmailEmpty() {
        return getEmail().trim().isEmpty();
    }
    
    public void addEmailTextFieldPlaceholder() {
        addPlaceholderStyle(tfEmail);
        tfEmail.setText("Masukan email");
    }
    
    public void addConfirmPasswordFieldPlaceholder() {
        addPlaceholderStyle(pfConfirmPassword);
        pfConfirmPassword.setText("Konfirmasi kata sandi");
        pfConfirmPassword.setEchoChar((char) 0);
    }
    
    public void checkPasswordInput() {
        boolean isEmpty = isPasswordEmpty() || isPasswordPlaceholderVisible();
        pfConfirmPassword.setEnabled(!isEmpty);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //java.awt.GradientPaint gp = new java.awt.GradientPaint(0, 0, java.awt.Color.decode("#e0eafc"), 0, getHeight(), java.awt.Color.decode("#cfdef3"));
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
        lbDescription2 = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        pfPassword = new javax.swing.JPasswordField();
        lbConfirmPassword = new javax.swing.JLabel();
        pfConfirmPassword = new javax.swing.JPasswordField();
        lbDescription = new javax.swing.JLabel();
        cbShowPassword = new javax.swing.JCheckBox();
        lbWarning = new javax.swing.JLabel();
        subPanel = new javax.swing.JPanel();
        lbLoginInfo = new javax.swing.JLabel();
        lbLinkLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tfUsername = new javax.swing.JTextField();
        lbUsername = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        lbGreeting.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        lbGreeting.setText("Selamat datang di Chillmeat Catering");
        lbGreeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGreetingMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 5, 35);
        add(lbGreeting, gridBagConstraints);

        lbDescription2.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        lbDescription2.setText("Segera daftar dan gabung");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 20, 0);
        add(lbDescription2, gridBagConstraints);

        lbPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbPassword.setText("Kata sandi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbPassword, gridBagConstraints);

        btnSignIn.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnSignIn.setText("Daftar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(btnSignIn, gridBagConstraints);

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(pfPassword, gridBagConstraints);

        lbConfirmPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbConfirmPassword.setText("Konfirmasi Kata sandi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbConfirmPassword, gridBagConstraints);

        pfConfirmPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        pfConfirmPassword.setText("Konfirmasi kata sandi");
        pfConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pfConfirmPasswordFocusLost(evt);
            }
        });
        pfConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfConfirmPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(pfConfirmPassword, gridBagConstraints);

        lbDescription.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        lbDescription.setText("Ikuti perjalanan cita rasa nusantara bersama kami");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(lbDescription, gridBagConstraints);

        cbShowPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        cbShowPassword.setText("Tampilkan kata sandi");
        cbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        add(cbShowPassword, gridBagConstraints);

        lbWarning.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbWarning.setForeground(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 10, 0);
        add(lbWarning, gridBagConstraints);

        subPanel.setBackground(new Color(0,0,0,0));

        lbLoginInfo.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbLoginInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoginInfo.setText("Punya akun?");
        subPanel.add(lbLoginInfo);

        lbLinkLogin.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbLinkLogin.setForeground(new java.awt.Color(102, 102, 255));
        lbLinkLogin.setText("<html><a href='#' style='color: blue;'>Masuk yuk</a></html>");
        lbLinkLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLinkLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLinkLoginMouseClicked(evt);
            }
        });
        subPanel.add(lbLinkLogin);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 35, 35);
        add(subPanel, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(tfUsername, gridBagConstraints);

        lbUsername.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbUsername.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbUsername, gridBagConstraints);

        tfEmail.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        tfEmail.setText("Masukan email");
        tfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEmailFocusLost(evt);
            }
        });
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(tfEmail, gridBagConstraints);

        lbEmail.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbEmail.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbEmail, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 0, 35);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lbGreetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGreetingMouseClicked
        
    }//GEN-LAST:event_lbGreetingMouseClicked

    private void pfConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfConfirmPasswordActionPerformed

    }//GEN-LAST:event_pfConfirmPasswordActionPerformed

    private void pfPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfPasswordFocusGained
        pfPassword.selectAll();
        registerPresenter.passwordFieldFocusGained();
    }//GEN-LAST:event_pfPasswordFocusGained

    private void lbLinkLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinkLoginMouseClicked
        registerPresenter.textLoginClicked();
    }//GEN-LAST:event_lbLinkLoginMouseClicked

    private void tfUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsernameFocusGained
        tfUsername.selectAll();
        registerPresenter.usernameTextFieldFocusGained();
    }//GEN-LAST:event_tfUsernameFocusGained

    private void tfUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsernameFocusLost
        registerPresenter.usernameTextFieldFocusLost();
        tfUsername.select(0, 0);
    }//GEN-LAST:event_tfUsernameFocusLost

    private void tfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusGained
        tfEmail.selectAll();
        registerPresenter.emailTextFieldFocusGained();
    }//GEN-LAST:event_tfEmailFocusGained

    private void tfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusLost
        registerPresenter.emailTextFieldFocusLost();
        tfEmail.select(0, 0);
    }//GEN-LAST:event_tfEmailFocusLost

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        pfPassword.requestFocus();
    }//GEN-LAST:event_tfEmailActionPerformed

    private void cbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPasswordActionPerformed
        registerPresenter.showHidePassword();
    }//GEN-LAST:event_cbShowPasswordActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        tfEmail.requestFocus();
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void pfPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfPasswordFocusLost
        registerPresenter.passwordFieldFocusLost();
        pfPassword.select(0, 0);
    }//GEN-LAST:event_pfPasswordFocusLost

    private void pfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPasswordActionPerformed
        pfConfirmPassword.requestFocus();
    }//GEN-LAST:event_pfPasswordActionPerformed

    private void pfConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfConfirmPasswordFocusGained
        pfConfirmPassword.selectAll();
        registerPresenter.confirmPasswordFieldFocusGained();
    }//GEN-LAST:event_pfConfirmPasswordFocusGained

    private void pfConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfConfirmPasswordFocusLost
        registerPresenter.confirmPasswordFieldFocusLost();
        pfConfirmPassword.select(0, 0);
    }//GEN-LAST:event_pfConfirmPasswordFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JCheckBox cbShowPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbConfirmPassword;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbDescription2;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGreeting;
    private javax.swing.JLabel lbLinkLogin;
    private javax.swing.JLabel lbLoginInfo;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JPanel subPanel;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

}
