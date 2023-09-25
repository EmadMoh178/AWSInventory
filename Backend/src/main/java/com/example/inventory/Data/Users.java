package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    private int id;
    private String userName;
    private String password;
}
