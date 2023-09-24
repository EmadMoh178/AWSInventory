package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.Data.OperatingSystems;

public interface OperatingSystemsRepository extends JpaRepository< OperatingSystems , Integer> {
    
}
