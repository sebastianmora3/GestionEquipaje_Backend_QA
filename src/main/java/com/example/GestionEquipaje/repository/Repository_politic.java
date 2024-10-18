package com.example.GestionEquipaje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionEquipaje.model.CollectionPolitic;

@Repository
public interface Repository_politic extends JpaRepository<CollectionPolitic, Long>  {
    
}
