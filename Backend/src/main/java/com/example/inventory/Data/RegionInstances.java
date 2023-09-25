package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "region_instances")
public class RegionInstances {
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions region;

    @ManyToOne
    @JoinColumn(name = "instance_id")
    private Ec2Instances instance;
    @Id
    double price_per_hour;
}
