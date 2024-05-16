package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Models.Region;

@Repository
public interface RegionRepository extends JpaRepository <Region, Integer>{
}
