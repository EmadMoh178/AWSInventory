package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "regions")
public class Regions {
    @Id
    int region_id;
    String region_short_name;
    String region_long_name;
}
