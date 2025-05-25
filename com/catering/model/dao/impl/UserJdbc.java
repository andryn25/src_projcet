package com.catering.model.dao.impl;

import com.catering.model.User;
import com.catering.model.dao.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class UserJdbc implements UserDao {

    private final Connection connection;

    public UserJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNama(resultSet.getString("nama"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }
            //com.catering.view.Console.log("Fetched " + users.size() + " users from the database.");
        } catch (SQLException e) {
            //com.catering.view.Console.logError("Error fetching all users: " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void insertUser(User user) {
        String query = "INSERT INTO users (nama, email, password, role) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getNama());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUser(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public User getUserByNama(String nama) {
        String query = "SELECT * FROM users WHERE nama = ?";
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nama);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setNama(resultSet.getString("nama"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(resultSet.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setNama(resultSet.getString("nama"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(resultSet.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
