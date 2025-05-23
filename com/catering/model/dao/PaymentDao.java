package com.catering.model.dao;

public interface PaymentDao {
    void insertPayment(com.catering.model.Payment payment);

    void updatePayment(com.catering.model.Payment payment);

    void deletePayment(java.lang.Integer id);

    com.catering.model.Payment getPaymentById(java.lang.Integer id);

    java.util.List<com.catering.model.Payment> getAllPayments();
}
