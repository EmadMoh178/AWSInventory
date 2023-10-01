package com.example.inventory.Data;

import lombok.Data;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ec2_instances")
public class Ec2Instances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer instanceId;
    String instanceName;
    @ManyToOne
    @JoinColumn(name = "vcpu_cores_id")
    VcpuCores vcpuCore;

    double memory;
    double networkPerformance;
    @ManyToOne
    @JoinColumn(name = "operating_systems_id")
    OperatingSystems operatingSystem;

    @OneToMany(mappedBy = "instance")
    private Set<RegionInstances> regionsSet;
}
