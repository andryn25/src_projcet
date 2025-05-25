package com.catering.app;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.EventQueue;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        //com.formdev.flatlaf.fonts.roboto.FlatRobotoFont.install();
        //com.formdev.flatlaf.FlatLaf.registerCustomDefaultsSource("com.catering.gui.themes");
        //javax.swing.UIManager.put("default font", new java.awt.Font(com.formdev.flatlaf.fonts.roboto.FlatRobotoFont.FAMILY, java.awt.Font.PLAIN, 12));
        //com.catering.view.test.LoginTest loginTest = new com.catering.view.test.LoginTest(userController);
        //com.catering.view.test.RegisterTest registerTest = new com.catering.view.test.RegisterTest(userController);
        //com.catering.view.test.MenusTest menusTest = new com.catering.view.test.MenusTest();
        //com.formdev.flatlaf.themes.FlatMacLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            new Application().setVisible(true);
        });
    }

}
