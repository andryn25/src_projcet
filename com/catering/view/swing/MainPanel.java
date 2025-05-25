package com.catering.view.swing;

import com.catering.presenter.MainPanelPresenter;
import com.catering.presenter.impl.PresenterFactory;
import com.catering.view.MainPanelView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.RenderingHints;
import javax.swing.GroupLayout;
import javax.swing.JComponent;

public class MainPanel extends javax.swing.JPanel implements MainPanelView {

    private final PresenterFactory presenterFactory = new PresenterFactory();
    private final MainPanelPresenter mainPanelPresenter;

    private enum BackgroundType {

        GRADIENT2, GRADIENT3, SOLID
    }
    private BackgroundType backgroundType = BackgroundType.GRADIENT2;

    private Color gradientStart = Color.decode("#ffffff");
    private Color gradientMiddle = Color.decode("#ffffff");
    private Color gradientEnd = Color.decode("#ffffff");
    private Color solidColor = Color.BLACK;

    public MainPanel() {
        mainPanelPresenter = presenterFactory.createMainPanelPresenter(this);
        initComponents();
    }

    // method gradiasi 2 warna
    public void useGradient2(Color start, Color end) {
        this.backgroundType = BackgroundType.GRADIENT2;
        this.gradientStart = start;
        this.gradientEnd = end;
        repaint();
    }

    //method gradiasi 3 warna
    public void useGradient3(Color start, Color middle, Color end) {
        this.backgroundType = BackgroundType.GRADIENT3;
        this.gradientStart = start;
        this.gradientMiddle = middle;
        this.gradientEnd = end;
        repaint();
    }

    //method warna solid
    public void useSolidBackground(Color background) {
        this.backgroundType = BackgroundType.SOLID;
        this.solidColor = background;
        setBackground(background);
        repaint();
    }

    //setup warna background
    @Override
    protected void paintComponent(Graphics g) {
        if (backgroundType == BackgroundType.SOLID) {
            setOpaque(true);
            super.paintComponent(g);
        } else {
            setOpaque(false);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (backgroundType == BackgroundType.GRADIENT2) {
                GradientPaint gp = new GradientPaint(0, 0, gradientStart, 0, getHeight(), gradientEnd);// getHeight = atas ke bawah, getWidth = kanan ke kiri
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            } else if (backgroundType == BackgroundType.GRADIENT3) {
                float[] fractions = {0.0f, 0.5f, 1.0f};
                Color[] colors = {
                    gradientStart,
                    gradientMiddle,
                    gradientEnd
                };
                LinearGradientPaint lgp = new LinearGradientPaint(0f, 0f, getWidth(), 0f, fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);//getHeight = atas ke bawah, getWidth = kanan ke kiri
                g2.setPaint(lgp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
            g2.dispose();
        }
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
        useGradient2(Color.decode("#ffb347"), Color.decode("#ffcc33"));
        revalidate();
        repaint();
    }

    @Override
    public void setSideBarPanel(JComponent sideBar) {
        removeAll();
        //setLayout(new BorderLayout(20, 20));
        //add(sideBar, BorderLayout.WEST);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(734, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        useGradient2(Color.decode("#FFF8E1"), Color.decode("#FFECB3"));
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBarMenu1 = new com.catering.view.menu.SidebarMenu();
        dashboard1 = new com.catering.view.menu.Dashboard();

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

        javax.swing.GroupLayout dashboard1Layout = new javax.swing.GroupLayout(dashboard1);
        dashboard1.setLayout(dashboard1Layout);
        dashboard1Layout.setHorizontalGroup(
            dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        dashboard1Layout.setVerticalGroup(
            dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(sideBarMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sideBarMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.catering.view.menu.Dashboard dashboard1;
    private com.catering.view.menu.SidebarMenu sideBarMenu1;
    // End of variables declaration//GEN-END:variables

}
