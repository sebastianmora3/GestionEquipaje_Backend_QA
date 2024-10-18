package com.example.GestionEquipaje.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Luggage")
public class Luggage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long luggage_id;
    private float weight;
    private String dimentions;
    private String luggage_location;
    private int quantity;
    private String type_luggage;
    
    //Constructor sin parametros
    public Luggage(){}
     // Este es el Constructor que contiene todo los parametros que recibe el equipaje
    public Luggage(Long luggage_id, float weight, String dimentions, String luggage_location, int quantity,String type_luggage) 
    {
        this.luggage_id = luggage_id;
        this.weight = weight;
        this.dimentions = dimentions;
        this.luggage_location = luggage_location;
        this.quantity = quantity;
        this.type_luggage = type_luggage;
    }

    public Long getLuggage_id() {
        return luggage_id;
    }

    public void setLuggage_id(Long luggage_id) {
        this.luggage_id = luggage_id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDimentions() {
        return dimentions;
    }

    public void setDimentions(String dimentions) {
        this.dimentions = dimentions;
    }

    public String getLuggage_location() {
        return luggage_location;
    }

    public void setLuggage_location(String luggage_location) {
        this.luggage_location = luggage_location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType_luggage() {
        return type_luggage;
    }

    public void setType_luggage(String type_luggage) {
        this.type_luggage = type_luggage;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @ManyToOne
    @JoinColumn (name = "booking_id")
    private Booking booking;
    @ManyToOne
    @JoinColumn (name = "id_politica")
    private CollectionPolitic changepolitic;
}
