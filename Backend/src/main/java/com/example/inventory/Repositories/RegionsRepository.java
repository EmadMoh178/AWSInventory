package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.Data.Regions;

public interface RegionsRepository extends JpaRepository <Regions , Integer>{
    
}
