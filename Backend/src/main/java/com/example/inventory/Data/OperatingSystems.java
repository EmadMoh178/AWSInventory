package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "operating_systems")
public class OperatingSystems {
    @Id
    int operating_system_id;
    String operating_system_name;
}
