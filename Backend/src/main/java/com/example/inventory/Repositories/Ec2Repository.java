package com.example.inventory.Repositories;

import com.example.inventory.Data.Ec2Instances;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Ec2Repository extends JpaRepository<Ec2Instances, Integer> {
}
