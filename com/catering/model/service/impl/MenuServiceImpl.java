package com.catering.model.service.impl;

class MenuServiceImpl implements com.catering.model.service.MenuService {
    private com.catering.model.dao.MenuDao menusDAO;

    public MenuServiceImpl(com.catering.model.dao.MenuDao menusDAO) {
        this.menusDAO = menusDAO;
    }

    @Override
    public com.catering.model.Menu tambahMenu(java.lang.String nama, double harga,
            java.lang.String deskripsi, java.lang.String kategori) {
        com.catering.model.Menu menu = new com.catering.model.Menu();
        menu.setNama(nama);
        menu.setHarga(harga);
        menu.setDeskripsi(deskripsi);
        menu.setKategori(kategori);
        if (menusDAO.getMenuByNama(nama) != null) {
            return null;
        }
        menu.setKetersediaan(true);
        menusDAO.insertMenu(menu);
        return menu;
    }

    @Override
    public com.catering.model.Menu hapusMenu(java.lang.String nama) {
        com.catering.model.Menu menu = menusDAO.getMenuByNama(nama);
        if (menu != null) {
            menusDAO.deleteMenu(nama);
        }
        return menu;
    }

    @Override
    public com.catering.model.Menu editMenu(java.lang.Integer id, java.lang.String nama, double harga,
            java.lang.String deskripsi, java.lang.String kategori, java.lang.Boolean ketersediaan) {
        com.catering.model.Menu menu = menusDAO.getMenuById(id);
        if (menu != null) {
            menu.setNama(nama);
            menu.setHarga(harga);
            menu.setDeskripsi(deskripsi);
            menu.setKategori(kategori);
            menu.setKetersediaan(ketersediaan);
            menusDAO.updateMenu(menu);
        }
        return menu;
    }

    @Override
    public java.util.List<com.catering.model.Menu> getAllMenus() {
        return menusDAO.getAllMenus();
    }

    @Override
    public java.lang.Boolean cekKetersediaan(java.lang.String nama) {
        return menusDAO.getMenuByNama(nama).getKetersediaan();
    }

}
