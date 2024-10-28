package com.example.GestionEquipaje.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import com.example.GestionEquipaje.model.Booking;
import com.example.GestionEquipaje.repository.Repository_booking;

public class Service_bookingTest {

    @Mock
    private Repository_booking repository_booking;

    @InjectMocks
    private Service_booking service_booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenFindAll_thenReturnBookingList() {
        // Arrange
        Booking booking1 = new Booking("PENDING");
        Booking booking2 = new Booking("CONFIRMED");
        List<Booking> expectedBookings = Arrays.asList(booking1, booking2);

        when(repository_booking.findAll()).thenReturn(expectedBookings);

        // Act
        List<Booking> actualBookings = service_booking.findAll(Sort.unsorted());

        // Assert
        assertEquals(expectedBookings, actualBookings);
        verify(repository_booking, times(1)).findAll();
    }

    @Test
    void whenFindAllWithNoBookings_thenReturnEmptyList() {
        // Arrange
        when(repository_booking.findAll()).thenReturn(Arrays.asList());

        // Act
        List<Booking> actualBookings = service_booking.findAll(Sort.unsorted());

        // Assert
        assertTrue(actualBookings.isEmpty());
        verify(repository_booking, times(1)).findAll();
    }
}
