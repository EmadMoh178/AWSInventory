package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.Data.RegionInstances;

public interface RegionInstancesRepository extends JpaRepository< RegionInstances,Integer> {
    
}
