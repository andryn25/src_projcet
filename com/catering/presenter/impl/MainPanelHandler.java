
package com.catering.presenter.impl;

import com.catering.presenter.MainPanelPresenter;
import com.catering.view.form.LoginForm;
import com.catering.view.MainPanelView;
import com.catering.view.menu.SidebarMenu;
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
        FormsManager.getInstance().showMenu(new SidebarMenu());
    }
}
