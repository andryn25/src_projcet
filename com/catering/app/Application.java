package com.catering.app;

import com.catering.presenter.LoginPresenter;
import com.catering.presenter.RegisterPresenter;
import com.catering.view.form.LoginForm;
import com.catering.view.form.RegisterForm;
import com.catering.view.manager.FormsManager;
import java.sql.Connection;

public class Application extends javax.swing.JFrame {

    private final MainPanel mainPanel;

    public Application(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        initComponents();
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        FormsManager.getInstance().initApplication(this, mainPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chillmeat Catering");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1080, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Connection connection = DatabaseConnection.getInstance().getConnection();
        MainPanel mainPanel = new MainPanel();
        LoginForm loginForm = new LoginForm();
        RegisterForm registerForm = new RegisterForm();
        MainPanelPresenter mainPanelPresenter = new MainPanelPresenter(mainPanel, loginForm, registerForm);
        LoginPresenter loginPresenter = new LoginPresenter(loginForm, mainPanelPresenter, connection);
        RegisterPresenter registerPresenter = new RegisterPresenter(registerForm, mainPanelPresenter, connection);
        mainPanel.setPresenter(mainPanelPresenter);
        loginForm.setPresenter(loginPresenter);
        registerForm.setPresenter(registerPresenter);
        mainPanel.setVisible(true);

        java.awt.EventQueue.invokeLater(() -> {
            new Application(mainPanel).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
