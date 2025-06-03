package com.catering.app;

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
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public final class MainPanel extends javax.swing.JPanel {

    private MainPanelPresenter mainPanelPresenter;

    private enum BackgroundType {

        GRADIENT2, GRADIENT3, SOLID, IMAGE
    }

    private BackgroundType backgroundType = BackgroundType.GRADIENT2;

    private BufferedImage backgroundImage;
    private Color gradientStart = Color.decode("#ffffff");
    private Color gradientMiddle = Color.decode("#ffffff");
    private Color gradientEnd = Color.decode("#ffffff");
    private Color solidColor = Color.BLACK;

    public MainPanel() {
        initComponents();
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            java.awt.EventQueue.invokeLater(() -> {
                mainPanelPresenter.showLoginForm();
            });
        }

    }

    public void setPresenter(MainPanelPresenter mainPanelPresenter) {
        this.mainPanelPresenter = mainPanelPresenter;
    }

    // gradiasi 2 warna
    public void useGradient2(Color start, Color end) {
        this.backgroundType = BackgroundType.GRADIENT2;
        this.gradientStart = start;
        this.gradientEnd = end;
        repaint();
    }

    // gradiasi 3 warna
    public void useGradient3(Color start, Color middle, Color end) {
        this.backgroundType = BackgroundType.GRADIENT3;
        this.gradientStart = start;
        this.gradientMiddle = middle;
        this.gradientEnd = end;
        repaint();
    }

    // warna solid
    public void useSolidBackground(Color background) {
        this.backgroundType = BackgroundType.SOLID;
        this.solidColor = background;
        setBackground(background);
        repaint();
    }

    //background dengan gambar
    public void useImageBackground() {
        this.backgroundType = BackgroundType.IMAGE;
        try {
            this.backgroundImage = ImageIO.read(new File("/home/achi/Downloads/bg.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        repaint();
    }

    // warna average sesui gambar background
    public Color getAverageColor(BufferedImage image) {
        long sumRed = 0, sumGreen = 0, sumBlue = 0;
        int width = image.getWidth();
        int height = image.getHeight();
        int count = 0;

        for (int y = 0; y < height; y += 5) { // lewati tiap 5 piksel untuk efisiensi
            for (int x = 0; x < width; x += 5) {
                int rgb = image.getRGB(x, y);
                Color c = new Color(rgb);
                sumRed += c.getRed();
                sumGreen += c.getGreen();
                sumBlue += c.getBlue();
                count++;
            }
        }

        return new Color((int) (sumRed / count), (int) (sumGreen / count), (int) (sumBlue / count));
    }

    //setup warna dan image background
    @Override
    protected void paintComponent(Graphics g) {
        if (backgroundType == BackgroundType.SOLID) {
            setOpaque(true);
            super.paintComponent(g);
        } else {
            setOpaque(false);
            Graphics2D g2 = (Graphics2D) g.create();
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
            } else if (backgroundType == BackgroundType.IMAGE) {
                if (backgroundImage != null) {
                    int panelWidth = getWidth();
                    int panelHeight = getHeight();

                    int imgWidth = backgroundImage.getWidth(null);
                    int imgHeight = backgroundImage.getHeight(null);

                    // Hitung rasio gambar dan panel
                    double imgAspect = (double) imgWidth / imgHeight;
                    double panelAspect = (double) panelWidth / panelHeight;

                    int drawWidth, drawHeight;
                    int x, y;

                    if (panelAspect > imgAspect) {
                        // Panel lebih lebar dari gambar: fit tinggi
                        drawHeight = panelHeight;
                        drawWidth = (int) (drawHeight * imgAspect);
                    } else {
                        // Panel lebih tinggi dari gambar: fit lebar
                        drawWidth = panelWidth;
                        drawHeight = (int) (drawWidth / imgAspect);
                    }

                    // Center-kan gambar
                    x = (panelWidth - drawWidth) / 2;
                    y = (panelHeight - drawHeight) / 2;

                    // Gambar dengan interpolasi halus
                    Color backgroundFillColor = getAverageColor(backgroundImage);
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2.setColor(backgroundFillColor);
                    g2.fillRect(0, 0, getWidth(), getHeight());
                    g2.drawImage(backgroundImage, x, y, drawWidth, drawHeight, this);
                }
                g2.dispose();
            }
        }
    }

    public void setForm(JComponent component) {
        removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(component, gbc);
        useGradient2(Color.decode("#ffb347"), Color.decode("#ffcc33"));
        revalidate();
        repaint();
    }

    public void setContentPanel(JComponent component) {
        removeAll();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        useGradient2(Color.decode("#FFF8E1"), Color.decode("#FFECB3"));
        component.setVisible(true);
        revalidate();
        repaint();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
