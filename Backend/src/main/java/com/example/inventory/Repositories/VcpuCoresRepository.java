package com.example.inventory.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.VcpuCores;

@Repository
public interface VcpuCoresRepository extends JpaRepository<VcpuCores,Integer> {
    VcpuCores findByCoreCount(Integer coreCount);
    Boolean existsByCoreCount(Integer coreCount);
}
