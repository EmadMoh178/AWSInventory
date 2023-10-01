package com.example.inventory.Data;

import lombok.Data;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "operating_systems")
public class OperatingSystems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer operatingSystemId; 
    String operatingSystemName;
}
