
package com.catering.presenter.impl;

import com.catering.view.impl.LoginForm;
import com.catering.view.MainPanelView;
import com.catering.view.manager.FormsManager;

public class MainPanelPresenterImpl {
    private final MainPanelView mainPanelView;
    
    public MainPanelPresenterImpl(MainPanelView mainPanelView) {
        this.mainPanelView = mainPanelView;
    }
    
    public void showLoginForm() {
        FormsManager.getInstance().showForm(new LoginForm());
    }
    
    public void showNavigationPanel() {
        
    }
}
