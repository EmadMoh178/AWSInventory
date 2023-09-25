package com.example.inventory.Services;


import com.example.inventory.Data.Users;
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
public class UserServices implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public Users addUser(Users user){
        return userRepository.save(user);
    }
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public Users login(Users user) throws UsernameNotFoundException {
        int id = user.getId();
        Optional<Users> usersOptional = userRepository.findById(id);
        Users loginUser;
        if(usersOptional.isEmpty())
            throw new UsernameNotFoundException("User with ID" + id + " is not found");
        loginUser = usersOptional.get();
        return loginUser;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }

}
