package com.example.inventory.Data;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

// @Data
@Embeddable
public class RegionInstancesKey implements Serializable {
    Integer regionId;
    Integer instanceId;
    public void setInstanceId(Integer instanceId){
        this.instanceId = instanceId;
    }
}
