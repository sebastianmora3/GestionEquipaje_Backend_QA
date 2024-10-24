package com.example.GestionEquipaje.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionEquipaje.model.Luggage;
import com.example.GestionEquipaje.service.Service_luggage;

@RestController
@RequestMapping("/api/Luggage")
public class Controller_luggage {

    @Autowired
    private Service_luggage service_luggage;

    // Endpoint -> Para consultar todos los equipajes
    @GetMapping("/consultar")
    public ResponseEntity<List<Luggage>> getAllLuggage() {
        return ResponseEntity.ok(service_luggage.findAll());
    }

    // Endpoint para obtener equipaje por Id
    @GetMapping("/consultar/{id}")
    public ResponseEntity<Luggage> getLuggageById(@PathVariable Long id) {
        Optional<Luggage> luggageOptional = service_luggage.findById(id);

        if (luggageOptional.isPresent()) {
            return ResponseEntity.ok(luggageOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint -> Para agregar el equipaje
    @PostMapping("/agregar")
    public ResponseEntity<Luggage> addLuggage(@RequestBody Luggage luggage) {
        Luggage newLuggage = service_luggage.save(luggage);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLuggage);
    }

    // Endpoint -> Para la modificación de un equipaje
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Luggage> updateLuggage(@PathVariable Long id, @RequestBody Luggage luggage) {
        Optional<Luggage> existingLuggageOptional = service_luggage.findById(id);

        if (existingLuggageOptional.isPresent()) {
            luggage.setLuggage_id(id); // Asegúrate de que tu modelo Luggage tenga este método
            Luggage updatedLuggage = service_luggage.save(luggage);
            return ResponseEntity.ok(updatedLuggage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint -> Para eliminar un equipaje con id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        service_luggage.deleteById(id);
        return ResponseEntity.ok("Eliminado exitosamente con número de Id = " + id);
    }
}
