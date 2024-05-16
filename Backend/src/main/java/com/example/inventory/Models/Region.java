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
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer regionId;
    String regionShortName;
    String regionLongName;
    public Region(int regionId){
        this.regionId = regionId;
    }
    public Region(){
    }
    @OneToMany(mappedBy = "region")
    private Set<RegionInstance> intancesSet;
}
