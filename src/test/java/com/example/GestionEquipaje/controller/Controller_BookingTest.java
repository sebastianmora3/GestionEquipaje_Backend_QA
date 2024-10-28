package com.example.GestionEquipaje.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.GestionEquipaje.model.Booking;
import com.example.GestionEquipaje.service.Service_booking;

@WebMvcTest(Controller_Booking.class)
public class Controller_BookingTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service_booking service_booking;

    private Booking booking1;
    private Booking booking2;
    private List<Booking> bookingList;

    @BeforeEach
    void setUp() {
        // Inicializar datos de prueba
        booking1 = new Booking("CONFIRMED");
        booking1.setBooking_id(1L);

        booking2 = new Booking("PENDING");
        booking2.setBooking_id(2L);

        bookingList = Arrays.asList(booking1, booking2);
    }

    @Test
    void getAllBooking_ShouldReturnAllBookings() throws Exception {
        // Arrange
        when(service_booking.findAll()).thenReturn(bookingList);

        // Act & Assert
        mockMvc.perform(get("/Bookings")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].booking_id", is(1)))
                .andExpect(jsonPath("$[0].status", is("CONFIRMED")))
                .andExpect(jsonPath("$[1].booking_id", is(2)))
                .andExpect(jsonPath("$[1].status", is("PENDING")));

        verify(service_booking, times(1)).findAll();
    }

    @Test
    void getAllBooking_ShouldReturnEmptyList() throws Exception {
        // Arrange
        when(service_booking.findAll()).thenReturn(Arrays.asList());

        // Act & Assert
        mockMvc.perform(get("/Bookings")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(service_booking, times(1)).findAll();
    }
}
