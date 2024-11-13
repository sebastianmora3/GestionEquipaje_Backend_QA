package com.example.GestionEquipaje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.GestionEquipaje.model.Booking;
import com.example.GestionEquipaje.service.Service_booking;

import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class Controller_Booking {

    @Autowired
    private Service_booking service_booking;
    

    // Endpoint para obtener una reserva y sus equipajes por ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingWithLuggage(@PathVariable Long id) {
        Optional<Booking> bookingOptional = service_booking.findBookingWithLuggage(id);
        
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
