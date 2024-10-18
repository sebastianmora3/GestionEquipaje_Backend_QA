package com.example.GestionEquipaje.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Politic")
public class CollectionPolitic implements Serializable{
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long changepolitic_id;
    private String type_politic;
    
    // Creamos el constructor
    public CollectionPolitic(Long changepolitic_id, String type_politic) {
        this.changepolitic_id = changepolitic_id;
        this.type_politic = type_politic;
    }
    
    public Long getChangepolitic_id() {
        return changepolitic_id;
    }
    public void setChangepolitic_id(Long changepolitic_id) {
        this.changepolitic_id = changepolitic_id;
    }
    
    public String getType_politic() {
        return type_politic;
    }

    public void setType_politic(String type_politic) {
        this.type_politic = type_politic;
    }

}
