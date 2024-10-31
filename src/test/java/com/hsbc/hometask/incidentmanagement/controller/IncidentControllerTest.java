package com.hsbc.hometask.incidentmanagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IncidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateIncident() throws Exception {
        mockMvc.perform(post("/api/incidents")
                        .contentType("application/json")
                        .content("{\"title\": \"Network issue\", \"description\": \"Server down\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Network issue"));
    }

    @Test
    public void testDeleteNonExistentIncident() throws Exception {
        mockMvc.perform(delete("/api/incidents/" + UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateIncident() throws Exception {
        // Create incident first and then update it in the test
    }

    @Test
    public void testListIncidents() throws Exception {
        mockMvc.perform(get("/api/incidents"))
                .andExpect(status().isOk());
    }
}
