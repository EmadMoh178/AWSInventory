// package com.example.inventory.Services;

// import com.example.inventory.Data.Users;
// import com.example.inventory.Repositories.UserRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.mockito.Mockito.*;
// import static org.junit.jupiter.api.Assertions.*;

// class UserServicesTest {

//     @Mock
//     private UserRepository userRepository;

//     @InjectMocks
//     // private UserServices userServices;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void addUserTest() {
//         Users user = new Users();
//         user.setId(1);
//         user.setUsername("testUser");

//         when(userRepository.save(any(Users.class))).thenReturn(user);

//         Users savedUser = userServices.addUser(user);

//         assertEquals(user.getId(), savedUser.getId());
//         assertEquals(user.getUsername(), savedUser.getUsername());
//         verify(userRepository, times(1)).save(user);
//     }

//     @Test
//     void getUsersTest() {
//         Users user1 = new Users();
//         Users user2 = new Users();
//         when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

//         List<Users> usersList = userServices.getUsers();

//         assertEquals(2, ((List<?>) usersList).size());
//         verify(userRepository, times(1)).findAll();
//     }

//     @Test
//     void loginValidUserTest() {
//         Users user = new Users();
//         user.setId(1);

//         when(userRepository.findById(1)).thenReturn(Optional.of(user));

//         Users loginUser = userServices.login(user);

//         assertEquals(user.getId(), loginUser.getId());
//     }

//     @Test
//     void loginInvalidUserTest() {
//         Users user = new Users();
//         user.setId(1);

//         when(userRepository.findById(1)).thenReturn(Optional.empty());

//         assertThrows(UsernameNotFoundException.class, () -> userServices.login(user));
//     }

//     @Test
//     void loadUserByUsernameValidTest() {
//         Users user = new Users();
//         user.setUsername("testUser");
//         user.setPassword("testPassword");

//         when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

//         UserDetails userDetails = userServices.loadUserByUsername("testUser");

//         assertEquals(user.getUsername(), userDetails.getUsername());
//         assertEquals(user.getPassword(), userDetails.getPassword());
//     }

//     @Test
//     void loadUserByUsernameInvalidTest() {
//         when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());

//         assertThrows(UsernameNotFoundException.class, () -> userServices.loadUserByUsername("testUser"));
//     }
// }
