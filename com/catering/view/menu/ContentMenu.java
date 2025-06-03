
package com.catering.view.menu;

import java.awt.Color;

public class ContentMenu extends javax.swing.JPanel {

    public ContentMenu() {
        initComponents();
        setOpaque(false);
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            java.awt.EventQueue.invokeLater(() -> {
                System.out.println("showup");
            });
        }

    }
    
    
    
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        //java.awt.GradientPaint gp = new java.awt.GradientPaint(0, 0, Color.decode("#abbaab"), 0, getHeight(), Color.decode("#abbaab"));
        //g2.setPaint(gp);
        g2.setColor(new Color(255,255,255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        //g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
