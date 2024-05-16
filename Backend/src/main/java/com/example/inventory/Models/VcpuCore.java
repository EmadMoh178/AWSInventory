package com.example.inventory.Models;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "vcpu_cores")
public class VcpuCore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer vcpuCoreId;
    Integer coreCount;
}