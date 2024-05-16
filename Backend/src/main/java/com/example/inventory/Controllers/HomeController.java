package com.example.inventory.Controllers;

import com.example.inventory.Models.Ec2Instance;
import com.example.inventory.Repositories.Ec2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class HomeController {

    @Autowired
    Ec2Repository ec2Repository;
    @GetMapping("/")
    public List<Ec2Instance> sayHello() {
        return ec2Repository.findAll();
    }

}
