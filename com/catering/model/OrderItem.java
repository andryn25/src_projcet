package com.catering.model;

public class OrderItem {
    private java.lang.Integer id;
    private java.lang.Integer orderId;
    private java.lang.Integer menuId;
    private java.lang.Integer jumlah;
    private java.lang.Double subTotal;

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

    public java.lang.Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(java.lang.Integer menuId) {
        this.menuId = menuId;
    }

    public java.lang.Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(java.lang.Integer jumlah) {
        this.jumlah = jumlah;
    }

    public java.lang.Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(java.lang.Double subTotal) {
        this.subTotal = subTotal;
    }

    public OrderItem() {
    }

}
