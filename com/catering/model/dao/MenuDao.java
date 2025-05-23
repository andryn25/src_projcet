package com.catering.model.dao;

public interface MenuDao {
    void insertMenu(com.catering.model.Menu menu);

    void updateMenu(com.catering.model.Menu menu);

    void deleteMenu(java.lang.String nama);

    com.catering.model.Menu getMenuById(java.lang.Integer id);

    java.util.List<com.catering.model.Menu> getAllMenus();
    
    com.catering.model.Menu getMenuByNama(java.lang.String nama);
}
 