package com.example.GestionEquipaje.repository;

import com.example.GestionEquipaje.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository_booking extends JpaRepository<Booking, Long> {

}
