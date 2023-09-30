package com.example.inventory.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.Regions;

@Repository
public interface RegionsRepository extends JpaRepository <Regions , Integer>{
    Regions findByRegionLongName(String regionLongName);
    Boolean existsByRegionLongName(String regionLongName);
}
