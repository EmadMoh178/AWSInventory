package com.example.inventory.Services;

import com.example.inventory.Models.User;
import com.example.inventory.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
     private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUserTest() {
        User user = new User();
        user.setId(1);
        user.setUsername("testUser");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.addUser(user);

        assertEquals(user.getId(), savedUser.getId());
        assertEquals(user.getUsername(), savedUser.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void getUsersTest() {
        User user1 = new User();
        User user2 = new User();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> usersList = userService.getUsers();

        assertEquals(2, ((List<?>) usersList).size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void loginValidUserTest() {
        User user = new User();
        user.setId(1);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        User loginUser = userService.login(user);

        assertEquals(user.getId(), loginUser.getId());
    }

    @Test
    void loginInvalidUserTest() {
        User user = new User();
        user.setId(1);

        when(userRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.login(user));
    }

    @Test
    void loadUserByUsernameValidTest() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

        UserDetails userDetails = userService.loadUserByUsername("testUser");

        assertEquals(user.getUsername(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
    }

    @Test
    void loadUserByUsernameInvalidTest() {
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("testUser"));
    }
}
