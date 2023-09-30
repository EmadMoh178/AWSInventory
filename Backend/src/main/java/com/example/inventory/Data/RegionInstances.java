package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "region_instances")
public class RegionInstances {
    @ManyToOne
    @JoinColumn(name = "regions_id")
    private Regions region;

    @ManyToOne
    @JoinColumn(name = "instances_id")
    private Ec2Instances instance;
    @Id
    private double pricePerHour;
}
