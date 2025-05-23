
package com.catering.app;

import com.catering.presenter.impl.MainPanelPresenterImpl;
import com.catering.view.impl.MainPanel;
import com.catering.view.manager.FormsManager;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application extends JFrame {
    
    private final MainPanel mainPanelViewImpl;
    
    public Application() {
        mainPanelViewImpl = new MainPanel();
        initComponents();
        setTitle("Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(420, 460));
        setLocationRelativeTo(null);
        setContentPane(mainPanelViewImpl);
        FormsManager.getInstance().initApplication(this, mainPanelViewImpl);
        new MainPanelPresenterImpl(mainPanelViewImpl).showLoginForm();
    }
    
    private void initComponents() {
        
    };
}
