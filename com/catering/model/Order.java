package com.catering.model;

public class Order {
    private java.lang.Integer id;
    private java.lang.Integer customerId;
    private java.util.Date tglPesan;
    private java.util.Date tglPengiriman;
    private java.lang.String status;

    public Order() {
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(java.lang.Integer customerId) {
        this.customerId = customerId;
    }

    public java.util.Date getTglPesan() {
        return tglPesan;
    }

    public void setTglPesan(java.util.Date tglPesan) {
        this.tglPesan = tglPesan;
    }

    public java.util.Date getTglPengiriman() {
        return tglPengiriman;
    }

    public void setTglPengiriman(java.util.Date tglPengiriman) {
        this.tglPengiriman = tglPengiriman;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

}
