package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Models.OperatingSystem;


@Repository
public interface OperatingSystemsRepository extends JpaRepository<OperatingSystem, Integer> {
}
