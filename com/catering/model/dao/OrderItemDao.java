package com.catering.model.dao;

public interface OrderItemDao {
    void insertOrderItems(com.catering.model.OrderItem orderItems);

    void updateOrderItems(com.catering.model.OrderItem orderItems);

    void deleteOrderItems(java.lang.Integer id);

    com.catering.model.OrderItem getOrderItemsById(java.lang.Integer id);

    java.util.List<com.catering.model.OrderItem> getAllOrderItems();
}
