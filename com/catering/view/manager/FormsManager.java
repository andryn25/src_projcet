
package com.catering.view.manager;

import com.catering.app.Application;
import com.catering.view.impl.MainPanel;
import java.awt.EventQueue;
import javax.swing.JComponent;

public class FormsManager {
    
    private static FormsManager instance;
    
    public static FormsManager getInstance() {
        if (instance == null) {
            instance = new FormsManager();
        }
        return instance;
    }
    
    public FormsManager() {
        
    }
    
    private Application application;
    private MainPanel mainPanel;
    
    public void initApplication(Application application, MainPanel mainPanel) {
        this.application = application;
        this.mainPanel = mainPanel;
    }
    
    public void showForm(JComponent component) {
        EventQueue.invokeLater(() -> {
            mainPanel.setLoginForm(component);
        });
    }
    
    public void showMenu(JComponent component) {
        EventQueue.invokeLater(() -> {
            mainPanel.setSideBarPanel(component);
            
        });
    }
    
    public void clearMenu(JComponent form) {
        EventQueue.invokeLater(() -> {
        });
    }
}
