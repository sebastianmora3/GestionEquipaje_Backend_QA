package com.example.GestionEquipaje.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.GestionEquipaje.model.Booking;
import com.example.GestionEquipaje.repository.Repository_booking;

@Service
public class Service_booking {

    @Autowired
    private Repository_booking Repository_booking;

    public Optional<Booking> findById(Long id) {
        return Repository_booking.findById(id);
    }

    public List<Booking> findAll() {
        return Repository_booking.findAll();
    }

    public Booking save(Booking entity) {
        return Repository_booking.save(entity);
    }

    public void deleteById(Long id) {
        Repository_booking.deleteById(id);
    }

    public void delete(Booking entity) {
        Repository_booking.delete(entity);
    }

    public long count() {
        return Repository_booking.count();
    }

    // Métodos de paginación
    public Page<Booking> findAll(Pageable pageable) {
        return Repository_booking.findAll(pageable);
    }

    public List<Booking> findAll(Sort sort) {
        return Repository_booking.findAll(sort);
    }
    // Método para obtener una reserva por su ID y los equipajes asociados
    public Optional<Booking> findBookingWithLuggage(Long id) {
        return Repository_booking.findById(id);
    }
    public Booking findByIdR(Long bookingId) {
        return Repository_booking.findById(bookingId).orElse(null);
    }

}

