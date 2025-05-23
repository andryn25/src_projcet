
package com.catering.presenter.impl;

import com.catering.presenter.MainPanelPresenter;
import com.catering.view.impl.LoginForm;
import com.catering.view.MainPanelView;
import com.catering.view.impl.SideBarMenu;
import com.catering.view.manager.FormsManager;

class MainPanelHandler implements MainPanelPresenter{
    private final MainPanelView mainPanelView;
    
    public MainPanelHandler(MainPanelView mainPanelView) {
        this.mainPanelView = mainPanelView;
    }
    
    @Override
    public void showLoginForm() {
        FormsManager.getInstance().showForm(new LoginForm());
    }
    
    @Override
    public void showDashboard() {
        FormsManager.getInstance().showMenu(new SideBarMenu());
    }
}
