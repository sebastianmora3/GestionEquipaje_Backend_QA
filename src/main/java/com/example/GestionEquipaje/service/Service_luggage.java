package com.example.GestionEquipaje.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.GestionEquipaje.model.Luggage;
import com.example.GestionEquipaje.repository.Repository_luggage;

@Service
public class Service_luggage {

    @Autowired
    private Repository_luggage repository_luggage;

    public Optional<Luggage> findById(Long id) {
        return repository_luggage.findById(id);
    }

    public List<Luggage> findAll() {
        return repository_luggage.findAll();
    }

    public Luggage save(Luggage entity) {
        return repository_luggage.save(entity);
    }

    public void deleteById(Long id) {
        repository_luggage.deleteById(id);
    }

    public void delete(Luggage entity) {
        repository_luggage.delete(entity);
    }

    public long count() {
        return repository_luggage.count();
    }

    // Métodos de paginación
    public Page<Luggage> findAll(Pageable pageable) {
        return repository_luggage.findAll(pageable);
    }

    public List<Luggage> findAll(Sort sort) {
        return repository_luggage.findAll(sort);
    }
    
}
