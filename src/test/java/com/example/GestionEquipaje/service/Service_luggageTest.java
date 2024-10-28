package com.example.GestionEquipaje.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.GestionEquipaje.model.Luggage;
import com.example.GestionEquipaje.repository.Repository_luggage;

@ExtendWith(MockitoExtension.class)
public class Service_luggageTest {

    @Mock
    private Repository_luggage repository_luggage;

    @InjectMocks
    private Service_luggage service_luggage;

    private Luggage luggage1;
    private Luggage luggage2;
    private List<Luggage> luggageList;

    @BeforeEach
    void setUp() {
        // Inicializar datos de prueba
        luggage1 = new Luggage(1L, 23.5f, "55x40x20", "Terminal 1", 1, "Carry-on");
        luggage2 = new Luggage(2L, 30.0f, "75x50x30", "Terminal 2", 2, "Checked");

        luggageList = new ArrayList<>();
        luggageList.add(luggage1);
        luggageList.add(luggage2);
    }

    @Test
    void findAll_ShouldReturnAllLuggage() {
        // Arrange
        when(repository_luggage.findAll()).thenReturn(luggageList);

        // Act
        List<Luggage> result = service_luggage.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(luggage1.getLuggage_id(), result.get(0).getLuggage_id());
        assertEquals(luggage2.getLuggage_id(), result.get(1).getLuggage_id());
        verify(repository_luggage, times(1)).findAll();
    }

    @Test
    void findAll_ShouldReturnEmptyList() {
        // Arrange
        when(repository_luggage.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Luggage> result = service_luggage.findAll();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(repository_luggage, times(1)).findAll();
    }

    @Test
    void delete_ShouldDeleteLuggage() {
        // Arrange
        doNothing().when(repository_luggage).delete(any(Luggage.class));

        // Act
        service_luggage.delete(luggage1);

        // Assert
        verify(repository_luggage, times(1)).delete(luggage1);
    }

    @Test
    void deleteById_ShouldDeleteLuggageById() {
        // Arrange
        Long id = 1L;
        doNothing().when(repository_luggage).deleteById(id);

        // Act
        service_luggage.deleteById(id);

        // Assert
        verify(repository_luggage, times(1)).deleteById(id);
    }

    @Test
    void save_ShouldSaveNewLuggage() {
        // Arrange
        Luggage newLuggage = new Luggage(null, 25.0f, "60x40x20", "Terminal 3", 1, "Carry-on");
        Luggage savedLuggage = new Luggage(3L, 25.0f, "60x40x20", "Terminal 3", 1, "Carry-on");
        when(repository_luggage.save(any(Luggage.class))).thenReturn(savedLuggage);

        // Act
        Luggage result = service_luggage.save(newLuggage);

        // Assert
        assertNotNull(result);
        assertEquals(savedLuggage.getLuggage_id(), result.getLuggage_id());
        assertEquals(savedLuggage.getWeight(), result.getWeight());
        assertEquals(savedLuggage.getDimentions(), result.getDimentions());
        assertEquals(savedLuggage.getLuggage_location(), result.getLuggage_location());
        assertEquals(savedLuggage.getQuantity(), result.getQuantity());
        assertEquals(savedLuggage.getType_luggage(), result.getType_luggage());
        verify(repository_luggage, times(1)).save(newLuggage);
    }

    @Test
    void save_ShouldUpdateExistingLuggage() {
        // Arrange
        Luggage updatedLuggage = new Luggage(1L, 26.0f, "55x40x20", "Terminal 4", 1, "Carry-on");
        when(repository_luggage.save(any(Luggage.class))).thenReturn(updatedLuggage);

        // Act
        Luggage result = service_luggage.save(updatedLuggage);

        // Assert
        assertNotNull(result);
        assertEquals(updatedLuggage.getLuggage_id(), result.getLuggage_id());
        assertEquals(updatedLuggage.getWeight(), result.getWeight());
        assertEquals(updatedLuggage.getLuggage_location(), result.getLuggage_location());
        verify(repository_luggage, times(1)).save(updatedLuggage);
    }

    // Tests para métodos no implementados
    @Test
    void flush_ShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service_luggage.flush();
        });
    }

    @Test
    void saveAndFlush_ShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service_luggage.saveAndFlush(luggage1);
        });
    }

    @Test
    void saveAllAndFlush_ShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service_luggage.saveAllAndFlush(luggageList);
        });
    }

    @Test
    void getOne_ShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service_luggage.getOne(1L);
        });
    }

    @Test
    void getById_ShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service_luggage.getById(1L);
        });
    }

    @Test
    void getReferenceById_ShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service_luggage.getReferenceById(1L);
        });
    }
}
