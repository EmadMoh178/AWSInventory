package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "region_instances")
public class RegionInstance {
    @EmbeddedId
    RegionInstancesKey id;
    @ManyToOne
    @MapsId("regionId")
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @MapsId("instanceId")
    @JoinColumn(name = "instance_id")
    private Ec2Instance instance;
    private double pricePerHour;
}
