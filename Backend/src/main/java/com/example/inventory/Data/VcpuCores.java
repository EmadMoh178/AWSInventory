package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "vcpu_cores")
public class VcpuCores {
    @Id
    int vcpu_core_id;
    int core_count;
}
