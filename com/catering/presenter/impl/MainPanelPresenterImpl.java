
package com.catering.presenter.impl;

import com.catering.view.impl.LoginFormImpl;
import com.catering.view.MainPanel;
import com.catering.view.manager.FormsManager;

public class MainPanelPresenterImpl {
    private final MainPanel mainPanelView;
    
    public MainPanelPresenterImpl(MainPanel mainPanelView) {
        this.mainPanelView = mainPanelView;
    }
    
    public void showLoginForm() {
        FormsManager.getInstance().showForm(new LoginFormImpl());
    }
    
    public void showNavigationPanel() {
        
    }
}
