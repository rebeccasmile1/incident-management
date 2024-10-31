package com.hsbc.hometask.incidentmanagement.controller;

import com.alibaba.fastjson2.JSON;
import com.hsbc.hometask.incidentmanagement.domain.entity.Incident;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
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
        Incident incident=new Incident();
        incident.setDescription("test create incident");
        incident.setTitle("test0");
        incident.setStatus(1);
        incident.setId(new UUID(30,30));
        MvcResult result = mockMvc.perform(post("/api/incidents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(incident)))
                .andExpect(status().isOk())
                .andReturn();
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
