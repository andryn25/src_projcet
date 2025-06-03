package com.catering.view.menu;

import com.catering.view.form.LoginForm;
import com.catering.view.manager.FormsManager;
import com.catering.view.model.Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class SidebarMenu extends javax.swing.JPanel {

    public SidebarMenu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        init();
    }
    
    private void init() {
        listMenu.addItem(new Menu("dashboard", "menu1", Menu.MenuType.MENU));
        listMenu.addItem(new Menu("dashboard", "menu2", Menu.MenuType.MENU));
        listMenu.addItem(new Menu("dashboard", "menu3", Menu.MenuType.MENU));
        listMenu.addItem(new Menu("dashboard", "menu4", Menu.MenuType.MENU));
        listMenu.addItem(new Menu("dashboard", "menu5", Menu.MenuType.MENU));
        listMenu.addItem(new Menu("dashboard", "menu6", Menu.MenuType.MENU));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#ffcc33"), 0, getHeight(), Color.decode("#ffcc33"));
        g2.setPaint(gp);
        //g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        listMenu = new com.catering.view.swing.ListMenu();

        lbTitle.setFont(new java.awt.Font("Nunito", 1, 20)); // NOI18N
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/logo-50.png"))); // NOI18N
        lbTitle.setText("ChillmeatCatering");
        lbTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTitleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTitleMouseClicked
        FormsManager.getInstance().showForm(new LoginForm());
    }//GEN-LAST:event_lbTitleMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitle;
    private com.catering.view.swing.ListMenu listMenu;
    // End of variables declaration//GEN-END:variables
}
