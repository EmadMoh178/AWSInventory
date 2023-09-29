package com.example.inventory.Controllers;

//import com.example.inventory.Repositories.Ec2Repository;
import com.example.inventory.DTO.SignUpDto;
import com.example.inventory.DTO.LoginDto;
import com.example.inventory.Data.Users;
import com.example.inventory.Repositories.UserRepository;
import com.example.inventory.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/login")
    public Users login(@RequestBody Users user){
        return userServices.login(user);
    }

    @PostMapping("/signup")
    public Users registerUser(@RequestBody Users user){
        return userServices.addUser(user);
    }
}




