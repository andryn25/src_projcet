package com.catering.model.dao;

public interface OrderDao {
    void insertOrder(com.catering.model.Order order);

    void updateOrder(com.catering.model.Order order);

    void deleteOrder(java.lang.Integer id);

    com.catering.model.Order getOrderById(java.lang.Integer id);

    java.util.List<com.catering.model.Order> getAllOrders();
}
