package com.hsbc.hometask.incidentmanagement.controller;

import com.hsbc.hometask.incidentmanagement.domain.entity.Incident;
import com.hsbc.hometask.incidentmanagement.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Resource
    private IncidentService incidentService;

    @PostMapping
    public ResponseEntity<Incident> createIncident(@Valid @RequestBody Incident incident) {
        return ResponseEntity.ok(incidentService.createIncident(incident));
    }

    @GetMapping
    public List<Incident> listIncidents() {
        return incidentService.getAllIncidents();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable UUID id, @Valid @RequestBody Incident incident) {
        return ResponseEntity.ok(incidentService.updateIncident(id, incident));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable UUID id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }
}
