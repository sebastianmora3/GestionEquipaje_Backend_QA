package com.example.GestionEquipaje.repository;

import com.example.GestionEquipaje.model.ChargePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_policy extends JpaRepository<ChargePolicy, Long>  {
    
}
