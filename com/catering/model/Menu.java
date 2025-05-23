package com.catering.model;

public class Menu {
    private java.lang.Integer id;
    private java.lang.String nama;
    private java.lang.String deskripsi;
    private java.lang.Double harga;
    private java.lang.Boolean ketersediaan;
    private java.lang.String kategori;

    public Menu() {
    } 

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getNama() {
        return nama;
    }

    public void setNama(java.lang.String nama) {
        this.nama = nama;
    }

    public java.lang.String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(java.lang.String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public java.lang.Double getHarga() {
        return harga;
    }

    public void setHarga(java.lang.Double harga) {
        this.harga = harga;
    }

    public java.lang.Boolean getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(java.lang.Boolean ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

    public java.lang.String getKategori() {
        return kategori;
    }

    public void setKategori(java.lang.String kategori) {
        this.kategori = kategori;
    }

}
