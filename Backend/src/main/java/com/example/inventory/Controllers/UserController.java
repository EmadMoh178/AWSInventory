package com.example.inventory.Controllers;

//import com.example.inventory.Repositories.Ec2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.inventory.Data.User;
@Controller
public class UserController {
//    @Autowired
//    private Ec2Repository userRepository;

    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

//    @PostMapping("/signup")
//    public String createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return "redirect:/login";
//    }
}
