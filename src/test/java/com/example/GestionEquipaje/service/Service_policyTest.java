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

import com.example.GestionEquipaje.model.CollectionPolitic;
import com.example.GestionEquipaje.repository.Repository_politic;

public class Service_policyTest {

    @Mock
    private Repository_politic repository_policy;

    @InjectMocks
    private Service_policy service_policy;

    private CollectionPolitic policy1;
    private CollectionPolitic policy2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        policy1 = new CollectionPolitic(1L, "STANDARD");
        policy2 = new CollectionPolitic(2L, "PREMIUM");
    }

    @Test
    void whenMethodNotImplemented_thenThrowException() {
        // Arrange
        List<CollectionPolitic> policies = Arrays.asList(policy1, policy2);

        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            service_policy.findAll();
        });

        assertThrows(UnsupportedOperationException.class, () -> {
            service_policy.save(policy1);
        });

        assertThrows(UnsupportedOperationException.class, () -> {
            service_policy.deleteById(1L);
        });
    }

    @Test
    void whenFindAllWithSort_thenThrowException() {
        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            service_policy.findAll(Sort.by("type_politic"));
        });
    }

    @Test
    void whenFindById_thenThrowException() {
        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            service_policy.findById(1L);
        });
    }
}
