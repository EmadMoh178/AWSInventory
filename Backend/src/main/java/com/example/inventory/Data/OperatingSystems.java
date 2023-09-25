package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "operating_systems")
public class OperatingSystems {
    @Id
    int operating_system_id;
    String operating_system_name;
}
