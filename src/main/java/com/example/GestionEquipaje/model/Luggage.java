package com.example.GestionEquipaje.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = true) // Relación con Booking
    @JsonBackReference
    private Booking booking; 
    @ManyToOne
    @JoinColumn(name = "id_politic", nullable = true) // Relación con CollectionPolitic
    private CollectionPolitic politic; // Cambiado a politic

    private float weight;
    private String dimentions; 
    private String luggage_location;
    private int quantity;
    private String type_luggage;

    // Constructor sin parámetros
    public Luggage() {}

    // Constructor que recibe todos los parámetros
    public Luggage(Long luggage_id, Booking booking, CollectionPolitic politic, float weight, String dimentions, String luggage_location, int quantity, String type_luggage) {
        this.luggage_id = luggage_id;
        this.booking = booking; // Usando el nuevo nombre
        this.politic = politic;
        this.weight = weight;
        this.dimentions = dimentions; 
        this.luggage_location = luggage_location;
        this.quantity = quantity;
        this.type_luggage = type_luggage;
    }

    // Getters y Setters
    public Long getLuggage_id() {
        return luggage_id;
    }

    public void setLuggage_id(Long luggage_id) {
        this.luggage_id = luggage_id;
    }

    public Booking getBooking() {
        return booking; // Cambiado a booking
    }

    public void setBooking(Booking booking) {
        this.booking = booking; // Cambiado a booking
    }

    public CollectionPolitic getPolitic() {
        return politic; // Cambiado a politic
    }

    public void setPolitic(CollectionPolitic politic) {
        this.politic = politic;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDimentions() { // Corregido a "getDimensions"
        return dimentions; // Corregido a "dimensions"
    }

    public void setDimentions(String dimentions) { // Corregido a "setDimensions"
        this.dimentions = dimentions; // Corregido a "dimensions"
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
        return "Luggage{" +
                "luggage_id=" + luggage_id +
                ", booking=" + booking +
                ", politic=" + politic +
                ", weight=" + weight +
                ", dimentions='" + dimentions + '\'' +
                ", luggage_location='" + luggage_location + '\'' +
                ", quantity=" + quantity +
                ", type_luggage='" + type_luggage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Luggage)) return false;
        Luggage luggage = (Luggage) obj;
        return luggage_id != null && luggage_id.equals(luggage.luggage_id);
    }

    @Override
    public int hashCode() {
        return 31; // Cambiar esto a una implementación que use luggage_id
    }
}
