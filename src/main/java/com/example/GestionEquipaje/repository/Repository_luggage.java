package com.example.GestionEquipaje.repository;

import com.example.GestionEquipaje.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_luggage extends JpaRepository<Luggage, Long> {
    
}
