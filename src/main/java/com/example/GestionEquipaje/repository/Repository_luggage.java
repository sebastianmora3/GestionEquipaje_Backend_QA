package com.example.GestionEquipaje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionEquipaje.model.Luggage;

@Repository
public interface Repository_luggage extends JpaRepository<Luggage, Long> {

}
