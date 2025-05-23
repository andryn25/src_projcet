package com.catering.model.dao;

public interface CustomerDao {
    void insertCustomer(com.catering.model.Customer customer);

    void updateCustomer(com.catering.model.Customer customer);

    void deleteCustomer(java.lang.Integer id);

    com.catering.model.Customer getCustomerById(java.lang.Integer id);

    java.util.List<com.catering.model.Customer> getAllCustomers();
}
