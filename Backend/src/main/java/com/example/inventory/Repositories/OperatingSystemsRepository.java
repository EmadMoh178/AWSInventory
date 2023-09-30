package com.example.inventory.Repositories;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.OperatingSystems;


@Repository
public interface OperatingSystemsRepository extends JpaRepository< OperatingSystems , Integer> {
    OperatingSystems findByOperatingSystemName(String operatingSystemName);
    Boolean existsByOperatingSystemName(String operatingSystemName);
}
