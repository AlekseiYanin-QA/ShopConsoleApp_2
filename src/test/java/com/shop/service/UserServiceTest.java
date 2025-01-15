package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setName("John");
        user.setEmail("john@example.com");
    }

    @Test
    void testAddUser() {
        userService.addUser(user);
        verify(userDao, times(1)).addUser(user);
    }

    @Test
    void testGetUserById() {
        when(userDao.getUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);
        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals("john@example.com", result.getEmail());

        verify(userDao, times(1)).getUserById(1);
    }

    @Test
    void testGetUserById_NotFound() {
        when(userDao.getUserById(1)).thenReturn(null);

        User result = userService.getUserById(1);
        assertNull(result);

        verify(userDao, times(1)).getUserById(1);
    }

    @Test
    void testGetAllUsers() {
        when(userDao.getAllUsers()).thenReturn(Collections.singletonList(user));

        List<User> result = userService.getAllUsers();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());

        verify(userDao, times(1)).getAllUsers();
    }

    @Test
    void testUpdateUser() {
        userService.updateUser(user);
        verify(userDao, times(1)).updateUser(user);
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1);
        verify(userDao, times(1)).deleteUser(1);
    }

    @Test
    void testAddUser_NullUser() {
        // Проверяем, что при передаче null выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> userService.addUser(null));
    }

    @Test
    void testUpdateUser_NullUser() {
        // Проверяем, что при передаче null выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> userService.updateUser(null));
    }
}