package com.catering.view.impl;

import com.catering.presenter.MainPanelPresenter;
import com.catering.presenter.impl.PresenterFactory;
import com.catering.view.MainPanelView;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import org.w3c.dom.events.MutationEvent;

public class MainPanel extends javax.swing.JPanel implements MainPanelView {

    private final PresenterFactory presenterFactory = new PresenterFactory();
    private final MainPanelPresenter mainPanelPresenter;

    public MainPanel() {
        mainPanelPresenter = presenterFactory.createMainPanelPresenter(this);
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    //setup background
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Dua warna
        //GradientPaint gp = new GradientPaint(0, 0, Color.decode("#ffffff"), 0, 0, Color.decode("#abbaab"));

        //Dua warna lebih
        float[] fractions = {0.0f, 0.5f, 1.0f};
        Color[] colors = {
            Color.decode("#0f2027"),
            Color.decode("#203a43"),
            Color.decode("#2c5364")
        };
        LinearGradientPaint lgp = new LinearGradientPaint(0f, 0f, getWidth(), 0f, fractions, colors);
        // set warna component
        g2.setPaint(lgp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setLoginForm(JComponent loginForm) {
        removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginForm, gbc);
        revalidate();
        repaint();
    }

    @Override
    public void setSideBarPanel(JComponent sideBar) {
        removeAll();
        setLayout(new BorderLayout(20,20));
        add(sideBar, BorderLayout.WEST);
        revalidate();
        repaint();
    }

}
