package com.example.inventory.Services;


import com.example.inventory.Models.User;
import com.example.inventory.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User login(User user) throws UsernameNotFoundException {
        int id = user.getId();
        Optional<User> usersOptional = userRepository.findById(id);
        User loginUser;
        if(usersOptional.isEmpty())
            throw new UsernameNotFoundException("User with ID" + id + " is not found");
        loginUser = usersOptional.get();
        return loginUser;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

}
