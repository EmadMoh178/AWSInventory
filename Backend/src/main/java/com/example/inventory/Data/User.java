package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;
    private String userName;
    private String password;
}