package com.catering.model;

public class Payment {
    private java.lang.Integer id;
    private java.lang.Integer orderId;
    private java.util.Date tglBayar;
    private java.lang.String metodeBayar;
    private java.lang.Double jumlahBayar;
    private java.lang.String statusBayar;

    public Payment() {
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

    public java.util.Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(java.util.Date tglBayar) {
        this.tglBayar = tglBayar;
    }

    public java.lang.String getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(java.lang.String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public java.lang.Double getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(java.lang.Double jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public java.lang.String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(java.lang.String statusBayar) {
        this.statusBayar = statusBayar;
    }

}
