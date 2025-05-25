
package com.catering.view.form;

import com.catering.app.DatabaseConnection;
import com.catering.presenter.RegisterPresenter;
import com.catering.presenter.impl.PresenterFactory;
import com.catering.view.RegisterView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RegisterForm extends javax.swing.JPanel implements RegisterView {
    
    private final PresenterFactory presenterFactory = new PresenterFactory();
    private final RegisterPresenter registerPresenter;
    
    public RegisterForm() {
        registerPresenter = presenterFactory.createrRegisterPresenter(this, DatabaseConnection.getInstance().getConnection());
        initComponents();
        setOpaque(false);
        addPlaceholderStyle(tfUsername);
        addPlaceholderStyle(tfEmail);
        addPlaceholderStyle(pfPassword);
        addPlaceholderStyle(pfConfirmPassword);
        
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
    
    @Override
    public String getNama() {
        return tfUsername.getText();
    }

    @Override
    public String getEmail() {
        return tfEmail.getText();
    }

    @Override
    public char[] getPassword() {
        return pfPassword.getPassword();
    }

    @Override
    public char[] getConfirmPassword() {
       return pfConfirmPassword.getPassword();
    }

    @Override
    public void showSignUpFailedMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showEmptyUsernameMessage() {
        lbWarning.setText("Silahkan masukkan username kamu.");
        lbWarning.setVisible(true);
    }

    @Override
    public void showEmptyPasswordMessage() {
        lbWarning.setText("Silahkan masukkan kata sandi kamu.");
        lbWarning.setVisible(true);
    }

    @Override
    public void hideAllMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPasswordVisible(boolean visible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isShowPasswordChecked() {
        return cbShowPassword.isSelected();
    }

    @Override
    public boolean isPasswordPlaceholderVisible() {
        return new String(getPassword()).equals("Masukan kata sandi") && new String(getPassword()).equals("Konfirmasi kata sandi");
    }

    @Override
    public void showEmptyEmailMessage() {
        lbWarning.setText("Silahkan masukkan email kamu.");
        lbWarning.setVisible(true);
    }

    @Override
    public void showEmptyConfirmPasswordMessage() {
        lbWarning.setText("Silahkan masukkan konfirmasi kata sandi kamu.");
        lbWarning.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //java.awt.GradientPaint gp = new java.awt.GradientPaint(0, 0, java.awt.Color.decode("#e0eafc"), 0, getHeight(), java.awt.Color.decode("#cfdef3"));
        //g2.setPaint(gp);
        g2.setColor(new Color(255, 255, 255, 100));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbGreeting = new javax.swing.JLabel();
        lbDescription2 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        pfPassword = new javax.swing.JPasswordField();
        lbConfirmPassword = new javax.swing.JLabel();
        pfConfirmPassword = new javax.swing.JPasswordField();
        tfUsername = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        lbDescription = new javax.swing.JLabel();
        cbShowPassword = new javax.swing.JCheckBox();
        lbWarning = new javax.swing.JLabel();
        subPanel = new javax.swing.JPanel();
        lbLoginInfo = new javax.swing.JLabel();
        lbLinkLogin = new javax.swing.JLabel();

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
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 5, 35);
        add(lbGreeting, gridBagConstraints);

        lbDescription2.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        lbDescription2.setText("Segera daftar dan gabung");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 20, 0);
        add(lbDescription2, gridBagConstraints);

        lbUsername.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbUsername.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbUsername, gridBagConstraints);

        lbEmail.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbEmail.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
        add(lbEmail, gridBagConstraints);

        lbPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbPassword.setText("Kata sandi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbPassword, gridBagConstraints);

        btnSignIn.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnSignIn.setText("Daftar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
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
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(pfPassword, gridBagConstraints);

        lbConfirmPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbConfirmPassword.setText("Konfirmasi Kata sandi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 5, 0);
        add(lbConfirmPassword, gridBagConstraints);

        pfConfirmPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        pfConfirmPassword.setText("Konfirmasi kata sandi");
        pfConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfConfirmPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(pfConfirmPassword, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 5);
        add(tfUsername, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 35);
        add(tfEmail, gridBagConstraints);

        lbDescription.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        lbDescription.setText("Ikuti perjalanan cita rasa nusantara bersama kami");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        add(lbDescription, gridBagConstraints);

        cbShowPassword.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        cbShowPassword.setText("Tampilkan kata sandi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        add(cbShowPassword, gridBagConstraints);

        lbWarning.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        lbWarning.setForeground(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
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
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 35, 35);
        add(subPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lbGreetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGreetingMouseClicked
        
    }//GEN-LAST:event_lbGreetingMouseClicked

    private void tfUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsernameFocusGained
        if (tfUsername.getText().equals("Masukan username")) {
            tfUsername.setText(null);
            tfUsername.requestFocus();
            removePlaceholderStyle(tfUsername);
        } else {
            tfUsername.selectAll();
        }
    }//GEN-LAST:event_tfUsernameFocusGained

    private void tfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusGained
        if (tfEmail.getText().equals("Masukan email")) {
            tfEmail.setText(null);
            tfEmail.requestFocus();
            removePlaceholderStyle(tfEmail);
        } else {
            tfEmail.selectAll();
        }
    }//GEN-LAST:event_tfEmailFocusGained

    private void tfUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsernameFocusLost
        if (tfUsername.getText().length() == 0) {
            addPlaceholderStyle(tfUsername);
            tfUsername.setText("Masukan username");
        } else {
            tfUsername.select(0,0);
        }
    }//GEN-LAST:event_tfUsernameFocusLost

    private void tfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusLost
        if (tfEmail.getText().length() == 0) {
            addPlaceholderStyle(tfEmail);
            tfEmail.setText("Masukan email");
        } else {
            tfEmail.select(0,0);
        }
    }//GEN-LAST:event_tfEmailFocusLost

    private void pfConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfConfirmPasswordActionPerformed

    private void pfPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfPasswordFocusGained
        
    }//GEN-LAST:event_pfPasswordFocusGained

    private void lbLinkLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLinkLoginMouseClicked
        registerPresenter.textLoginClicked();
    }//GEN-LAST:event_lbLinkLoginMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JCheckBox cbShowPassword;
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
