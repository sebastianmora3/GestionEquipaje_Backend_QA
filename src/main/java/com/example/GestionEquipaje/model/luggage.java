package com.example.GestionEquipaje.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Equipaje")
public class Luggage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long luggage_id;
    private float weight;
    private String dimentions;
    private String luggage_location;
    private int quantity;
    private String type_luggage;
    
    @ManyToOne
    @JoinColumn (name = "id_reserva")
    private Booking booking;
    @ManyToOne
    @JoinColumn (name = "id_politica")
    private ChargePolicy chargePolicy;

    public Luggage() {
    }

    public Luggage(float weight, String dimentions, String luggage_location, int quantity, String type_luggage, Booking booking, ChargePolicy chargePolicy) {
        this.weight = weight;
        this.dimentions = dimentions;
        this.luggage_location = luggage_location;
        this.quantity = quantity;
        this.type_luggage = type_luggage;
        this.booking = booking;
        this.chargePolicy = chargePolicy;
    }

    public Long getLuggage_id() {
        return luggage_id;
    }

    public float getWeight() {
        return weight;
    }

    public String getDimentions() {
        return dimentions;
    }

    public String getLuggage_location() {
        return luggage_location;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType_luggage(){
        return type_luggage;
    }

    public Booking getBooking() {
        return booking;
    }

    public ChargePolicy getChargePolicy() {
        return chargePolicy;
    }

    public void setLuggage_id(Long luggage_id) {
        this.luggage_id = luggage_id;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDimentions(String dimentions) {
        this.dimentions = dimentions;
    }

    public void setLuggage_location(String luggage_location) {
        this.luggage_location = luggage_location;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType_luggage(String type_luggage) {
        this.type_luggage = type_luggage;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setChargePolicy(ChargePolicy chargePolicy) {
        this.chargePolicy = chargePolicy;
    }

    @Override 
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Luggage luggage = (Luggage) o;
        return Objects.equals(getLuggage_id(), luggage.getLuggage_id() );
    }

    @Override 
    public int hashCode() {
        return Objects.hash(getLuggage_id());
    }

    @Override
    public String toString() {
        return "luggage [luggage_id= " + luggage_id + 
               ", weight= " + weight + 
               ", dimentions= " + dimentions + 
               ", luggage_location= " + luggage_location + 
               ", quantity= " + quantity + 
               ", type_luggage= " + type_luggage +
               "]";
    
            } 
}
