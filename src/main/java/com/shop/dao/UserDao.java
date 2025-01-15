package com.shop.dao;

import com.shop.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}