package com.example.inventory.Services;


import com.example.inventory.Data.Users;
import com.example.inventory.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public Users addUser(Users user){
        return userRepository.save(user);
    }
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public Users login(Users user){
        int id = user.getId();
        String password = user.getPassword();
        Optional<Users> usersOptional = userRepository.findById(id);
        Users loginUser = new Users();
        if(usersOptional.isPresent())
            loginUser = usersOptional.get();
        return loginUser;
    }

}
