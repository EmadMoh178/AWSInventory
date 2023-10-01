package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "region_instances")
public class RegionInstances {
    @EmbeddedId
    RegionInstancesKey id;
    @ManyToOne
    @MapsId("regionId")
    @JoinColumn(name = "region_id")
    private Regions region;

    @ManyToOne
    @MapsId("instanceId")
    @JoinColumn(name = "instance_id")
    private Ec2Instances instance;
    private double pricePerHour;
}
