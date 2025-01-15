package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        userDao.addUser(user);
        logger.info("User added: {}", user);
    }

    public User getUserById(int id) {
        User user = userDao.getUserById(id);
        logger.info("User retrieved: {}", user);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        logger.info("All users retrieved: {}", users);
        return users;
    }

    public void updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        userDao.updateUser(user);
        logger.info("User updated: {}", user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
        logger.info("User deleted with id: {}", id);
    }
}