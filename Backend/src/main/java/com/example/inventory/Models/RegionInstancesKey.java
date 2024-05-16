package com.example.inventory.Models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

// @Data
@Embeddable
public class RegionInstancesKey implements Serializable {
    Integer regionId;
    Integer instanceId;
    public void setInstanceId(Integer instanceId){
        this.instanceId = instanceId;
    }
}
