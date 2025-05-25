package com.catering.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlideAnimationExample extends JFrame {
    private JPanel container;
    private JPanel slide1, slide2;
    private int animationSpeed = 1; // pixel per frame
    private int frameDelay = 1;      // delay per frame (ms)

    public SlideAnimationExample() {
        setTitle("Slide Animation Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        container = new JPanel(null);
        container.setBounds(0, 0, 400, 300);
        add(container);

        // Slide 1
        slide1 = new JPanel();
        slide1.setBackground(Color.CYAN);
        slide1.setBounds(0, 0, 400, 300);
        container.add(slide1);

        // Slide 2
        slide2 = new JPanel();
        slide2.setBackground(Color.PINK);
        slide2.setBounds(400, 0, 400, 300); // Awalnya di luar kanan layar
        container.add(slide2);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(150, 220, 100, 30);
        slide1.add(nextButton);

        nextButton.addActionListener(e -> animateSlide(slide1, slide2));

        setVisible(true);
    }

    private void animateSlide(JPanel current, JPanel next) {
        Timer timer = new Timer(frameDelay, null);
        timer.addActionListener(new ActionListener() {
            int x = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                x += animationSpeed;
                if (x >= 400) {
                    timer.stop();
                } else {
                    current.setLocation(-x, 0);
                    next.setLocation(400 - x, 0);
                }
                container.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SlideAnimationExample());
    }
}
