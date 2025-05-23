package com.catering.model.dao;

public interface DeliveryDao {
    void insertDelivery(com.catering.model.Delivery delivery);

    void updateDelivery(com.catering.model.Delivery delivery);

    void deleteDelivery(java.lang.Integer id);

    com.catering.model.Delivery getDeliveryById(java.lang.Integer id);

    java.util.List<com.catering.model.Delivery> getAllDeliveries();
}
