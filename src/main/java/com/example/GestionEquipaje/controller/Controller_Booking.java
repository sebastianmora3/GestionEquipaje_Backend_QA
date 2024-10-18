package com.example.GestionEquipaje.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionEquipaje.model.Booking;
import com.example.GestionEquipaje.service.Service_booking;


@RestController
@RequestMapping("/Bookings")
public class Controller_Booking {
@Autowired
private Service_booking service_booking;

@GetMapping
private ResponseEntity<List<Booking>> getAllBooking(){

    return ResponseEntity.ok(service_booking.findAll());
}

// Estos controller son manipulados por el modulo Gestion de Reservas, no de equipajes.
}


