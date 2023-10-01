package com.example.inventory.Data;

import lombok.Data;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "regions")
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer regionId;
    String regionShortName;
    String regionLongName;
    public Regions(int regionId){
        this.regionId = regionId;
    }
    public Regions(){
    }
    @OneToMany(mappedBy = "region")
    private Set<RegionInstances> intancesSet;
}
