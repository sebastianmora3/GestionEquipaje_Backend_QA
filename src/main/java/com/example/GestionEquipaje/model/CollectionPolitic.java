package com.example.GestionEquipaje.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "politic")
public class CollectionPolitic implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_politic;
    private String type_politic;

    // Creamos el constructor vacio
    public CollectionPolitic() {}

    // Creamos el constructor
    public CollectionPolitic(Long id_politic, String type_politic) {
        this.id_politic = id_politic;
        this.type_politic = type_politic;
    }
    
    public Long getid_politic() {
        return id_politic;
    }
    public void setid_politic(Long id_politic) {
        this.id_politic = id_politic;
    }
    
    public String getType_politic() {
        return type_politic;
    }

    public void setType_politic(String type_politic) {
        this.type_politic = type_politic;
    }

}
