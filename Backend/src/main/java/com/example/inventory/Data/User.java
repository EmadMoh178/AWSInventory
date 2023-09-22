package com.example.inventory.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class User {

    @Id
    private Long id;
    private String userName;
    private String password;
}
