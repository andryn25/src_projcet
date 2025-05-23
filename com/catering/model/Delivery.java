package com.catering.model;

public class Delivery {
    private java.lang.Integer id;
    private java.lang.Integer orderId;
    private java.lang.String alamatPengiriman;
    private java.lang.String statusPengiriman;
    private java.lang.String namaKurir;

    public Delivery() {
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(java.lang.Integer orderId) {
        this.orderId = orderId;
    }

    public java.lang.String getAlamatPengiriman() {

        return alamatPengiriman;
    }

    public void setAlamatPengiriman(java.lang.String alamatPengiriman) {
        this.alamatPengiriman = alamatPengiriman;
    }

    public java.lang.String getStatusPengiriman() {

        return statusPengiriman;
    }

    public void setStatusPengiriman(java.lang.String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public java.lang.String getNamaKurir() {
        return namaKurir;
    }

    public void setNamaKurir(java.lang.String namaKurir) {
        this.namaKurir = namaKurir;
    }

}
