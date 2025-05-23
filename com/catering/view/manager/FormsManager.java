
package com.catering.view.manager;

import com.catering.app.Application;
import com.catering.view.impl.MainPanelImpl;
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
    private MainPanelImpl mainPanelViewImpl;
    
    public void initApplication(Application application, MainPanelImpl mainPanelViewImpl) {
        this.application = application;
        this.mainPanelViewImpl = mainPanelViewImpl;
    }
    
    public void showForm(JComponent form) {
        EventQueue.invokeLater(() -> {
            mainPanelViewImpl.setLayoutForm(form);
        });
    }
    
    public void showMenu(JComponent form) {
        EventQueue.invokeLater(() -> {
            
        });
    }
    
    public void clearMenu(JComponent form) {
        EventQueue.invokeLater(() -> {
        });
    }
}
