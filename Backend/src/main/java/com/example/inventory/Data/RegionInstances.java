package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.*;

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

    double price_per_hour;
}
