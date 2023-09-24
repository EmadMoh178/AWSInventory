package com.example.inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.Data.VcpuCores;

public interface VcpuCoresRepository extends JpaRepository<VcpuCores,Integer> {
    
}
