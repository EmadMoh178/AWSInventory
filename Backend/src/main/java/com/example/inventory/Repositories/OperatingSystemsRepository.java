package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.OperatingSystems;


@Repository
public interface OperatingSystemsRepository extends JpaRepository< OperatingSystems , Integer> {
    
}
