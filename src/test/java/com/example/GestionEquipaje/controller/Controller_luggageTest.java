package com.example.GestionEquipaje.controller;

import com.example.GestionEquipaje.model.Luggage;
import com.example.GestionEquipaje.service.Service_luggage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Controller_luggageTest {

    @Mock
    private Service_luggage service_luggage;

    @InjectMocks
    private Controller_luggage controller_luggage;

    @Test
    void getAllLuggage_shouldReturnAllLuggage() {
        // Arrange
        List<Luggage> luggageList = Arrays.asList(
                new Luggage(1L, 20.5f, "60x40x20", "Location A", 1, "Carry-on"),
                new Luggage(2L, 25.0f, "70x50x30", "Location B", 1, "Check-in")
        );
        when(service_luggage.findAll()).thenReturn(luggageList);

        // Act
        ResponseEntity<List<Luggage>> response = controller_luggage.getAllLuggage();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(luggageList, response.getBody());
        verify(service_luggage, times(1)).findAll();
    }

    @Test
    void getLuggageById_whenLuggageExists_shouldReturnLuggage() {
        // Arrange
        Long id = 1L;
        Luggage luggage = new Luggage(id, 20.5f, "60x40x20", "Location A", 1, "Carry-on");
        when(service_luggage.getById(id)).thenReturn(luggage);

        // Act
        ResponseEntity<Luggage> response = controller_luggage.getLuggageById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(luggage, response.getBody());
        verify(service_luggage, times(1)).getById(id);
    }

    @Test
    void getLuggageById_whenLuggageDoesNotExist_shouldReturnNotFound() {
        // Arrange
        Long id = 1L;
        when(service_luggage.getById(id)).thenReturn(null);

        // Act
        ResponseEntity<Luggage> response = controller_luggage.getLuggageById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(service_luggage, times(1)).getById(id);
    }

    @Test
    void addLuggage_shouldReturnCreatedLuggage() {
        // Arrange
        Luggage luggage = new Luggage(null, 20.5f, "60x40x20", "Location A", 1, "Carry-on");
        Luggage savedLuggage = new Luggage(1L, 20.5f, "60x40x20", "Location A", 1, "Carry-on");
        when(service_luggage.save(luggage)).thenReturn(savedLuggage);

        // Act
        ResponseEntity<Luggage> response = controller_luggage.addLuggage(luggage);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedLuggage, response.getBody());
        verify(service_luggage, times(1)).save(luggage);
    }

    @Test
    void deleteById_shouldReturnSuccessMessage() {
        // Arrange
        Long id = 1L;

        // Act
        String result = controller_luggage.deleteById(id);

        // Assert
        assertEquals("Eliminado exitosamente con numero de Id = " + id, result);
        verify(service_luggage, times(1)).deleteById(id);
    }
}