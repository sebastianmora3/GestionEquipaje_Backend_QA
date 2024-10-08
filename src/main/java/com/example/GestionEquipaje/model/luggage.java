package com.example.GestionEquipaje.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
public class luggage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int luggage_id;
    private float weight;
    private String dimentions;
    private String luggage_location;
    private int quantity;
    private String type_luggage;
    private int booking_id;
    private int payment_id;
    private int luggage_type_id;

    public luggage() {
    }

    public luggage(int luggage_id, float weight, String dimentions, String luggage_location, int quantity, String type_luggage, int booking_id, int payment_id, int luggage_type_id) {
        this.luggage_id = luggage_id;
        this.weight = weight;
        this.dimentions = dimentions;
        this.luggage_location = luggage_location;
        this.quantity = quantity;
        this.type_luggage = type_luggage;
        this.booking_id = booking_id;
        this.payment_id = payment_id;
        this.luggage_type_id = luggage_type_id;
    }

    public int getLuggage_id() {
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

    public int getBooking_id() {
        return booking_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public int getLuggage_type_id() {
        return luggage_type_id;
    }

    public void setLuggage_id(int luggage_id) {
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

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public void setLuggage_type_id(int luggage_type_id) {
        this.luggage_type_id = luggage_type_id;
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
