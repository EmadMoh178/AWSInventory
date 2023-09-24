package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "VcpuCores")
public class VcpuCores {
    @Id
    int vcpu_core_id;
    int core_count;
}
