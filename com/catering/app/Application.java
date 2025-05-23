
package com.catering.app;

import com.catering.presenter.MainPanelPresenter;
import com.catering.presenter.impl.PresenterFactory;
import com.catering.view.impl.MainPanel;
import com.catering.view.manager.FormsManager;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Application extends JFrame {
    
    private final PresenterFactory presenterFactory = new PresenterFactory();
    private final MainPanelPresenter mainPanelPresenter;
    private final MainPanel mainPanel;
    
    public Application() {
        mainPanel = new MainPanel();
        mainPanelPresenter = presenterFactory.createMainPanelPresenter(mainPanel);
        initComponents();
        FormsManager.getInstance().initApplication(this, mainPanel);
        mainPanelPresenter.showLoginForm();
    }
    
    private void initComponents() {
        setTitle("Catering App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(420, 460));
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
    };
}
