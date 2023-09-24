package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.RegionInstances;

@Repository
public interface RegionInstancesRepository extends JpaRepository< RegionInstances,Integer> {
    
}
