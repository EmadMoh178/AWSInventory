package com.example.inventory.Repositories;

import com.example.inventory.Data.Ec2Instances;
import com.example.inventory.Data.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface Ec2Repository extends JpaRepository<Ec2Instances, Integer> {
    Optional<User> findByUsername(String username);
}
