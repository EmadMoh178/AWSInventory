package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ec2_instances")
public class Ec2Instances {
    @Id
    int instance_id;
    String instance_name;
    @ManyToOne
    @JoinColumn(name = "vcpu_core_id")
    VcpuCores vcpuCore;

    double memory;
    double network_performance;
    @ManyToOne
    @JoinColumn(name = "operating_system_id")
    OperatingSystems operatingSystem;
}
