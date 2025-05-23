package com.catering.model.service;

public interface MenuService {
    com.catering.model.Menu tambahMenu(java.lang.String nama, double harga,
            java.lang.String deskripsi, java.lang.String kategori);
    com.catering.model.Menu hapusMenu(java.lang.String nama); 
    com.catering.model.Menu editMenu(java.lang.Integer id, java.lang.String nama, double harga,
            java.lang.String deskripsi, java.lang.String kategori, java.lang.Boolean ketersediaan);
    java.util.List<com.catering.model.Menu> getAllMenus();
    java.lang.Boolean cekKetersediaan(java.lang.String nama);
}
 