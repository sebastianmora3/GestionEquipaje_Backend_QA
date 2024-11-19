package com.example.GestionEquipaje.model;

import java.io.Serializable;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "booking")
public class Booking implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;
    private String status;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Luggage> luggageList;

    //constructor Vacio
    public Booking (){}

    //Constructo con paramentros
    public Booking(String status, List<Luggage> luggageList) {
        super();
        this.status = status;
        this.luggageList = luggageList;
    }

    public List<Luggage> getLuggageList() {
        return luggageList;
    }

    public void setLuggageList(List<Luggage> luggageList) {
        this.luggageList = luggageList;
    }

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
