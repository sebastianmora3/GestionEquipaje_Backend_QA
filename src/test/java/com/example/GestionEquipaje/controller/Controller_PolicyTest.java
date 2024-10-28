package com.example.GestionEquipaje.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.GestionEquipaje.model.CollectionPolitic;
import com.example.GestionEquipaje.service.Service_policy;

@WebMvcTest(Controller_policy.class)
public class Controller_PolicyTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service_policy service_policy;

    private CollectionPolitic policy1;
    private CollectionPolitic policy2;

    @BeforeEach
    void setUp() {
        policy1 = new CollectionPolitic(1L, "STANDARD");
        policy2 = new CollectionPolitic(2L, "PREMIUM");
    }
    
    @Test
    void whenGetAllPolicy_withEmptyList_thenReturn200() throws Exception {
        // Arrange
        when(service_policy.findAll()).thenReturn(Arrays.asList());

        // Act & Assert
        mockMvc.perform(get("/Politics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void whenGetAllPolicy_withPolicies_thenReturnPoliciesList() throws Exception {
        // Arrange
        List<CollectionPolitic> policies = Arrays.asList(policy1, policy2);
        when(service_policy.findAll()).thenReturn(policies);

        // Act & Assert
        mockMvc.perform(get("/Politics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
