package com.catering.model.service;

import com.catering.model.User;

public interface UserService {
   User login(String nama, String password);

   User register(String nama, String password, String email);

   boolean cekAdmin(User user);

   boolean cekCustomer(User user);   
}
