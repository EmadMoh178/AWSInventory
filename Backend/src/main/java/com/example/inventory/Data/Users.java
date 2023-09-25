package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    private int id;
    private String username;
    private String password;
}
