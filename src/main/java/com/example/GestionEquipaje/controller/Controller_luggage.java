package com.example.GestionEquipaje.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionEquipaje.model.Luggage;
import com.example.GestionEquipaje.service.Service_luggage;

@RestController
@RequestMapping("/equipaje")
public class Controller_luggage {

    @Autowired
    private Service_luggage service_luggage;
    
    @GetMapping
    private ResponseEntity<List<Luggage>> getAllLuggage () {
        return ResponseEntity.ok(service_luggage.findAll());
    }

    @PostMapping("/agregar")
    private ResponseEntity<Luggage> agregarEquipaje (@RequestBody Luggage luggage)  {
        Luggage newLuggage = service_luggage.save(luggage);
        return ResponseEntity.ok(newLuggage);
    } 

    // return ResponseEntity.created(new URI("/agregar/"+newLuggage.tLuggage_id())).body(newLuggage);

}
