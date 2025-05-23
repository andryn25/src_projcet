
package com.catering.view.swing;

public class PlaceholderTextField extends javax.swing.JTextField{
    
    private String placeholder;

    public PlaceholderTextField(String placeholder, int columns) {
        super(columns);
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && !isFocusOwner()) {
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
            g2.setColor(java.awt.Color.GRAY);
            g2.setFont(getFont().deriveFont(java.awt.Font.ITALIC));
            g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
            g2.dispose();
        }
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }
    
}
