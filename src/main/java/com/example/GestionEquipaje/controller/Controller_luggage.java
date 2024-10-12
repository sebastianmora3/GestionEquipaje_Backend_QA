package com.example.GestionEquipaje.controller;

import java.util.List;

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
@RequestMapping("/equipaje")
public class Controller_luggage {

    @Autowired
    private Service_luggage service_luggage;
    
    @GetMapping ("/consultar")
    private ResponseEntity<List<Luggage>> getAllLuggage () {
        return ResponseEntity.ok(service_luggage.findAll());
    }

    // creamos el post para agregar el equipaje 
    @PostMapping("/agregar")
    private ResponseEntity<Luggage> addLuggage (@RequestBody Luggage luggage)  {
        Luggage newLuggage = service_luggage.save(luggage);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLuggage);
    } 

    // creamos el put para la modificacion de un equipaje
    @PutMapping("path/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
    //Creamos el de eliminar un equipaje con id
    @DeleteMapping("/eliminar/{id}")
    public void deleteEquipaje (@PathVariable Long id){

       service_luggage.deleteById(id);
    }





    // return ResponseEntity.created(new URI("/agregar/"+newLuggage.tLuggage_id())).body(newLuggage);

}
