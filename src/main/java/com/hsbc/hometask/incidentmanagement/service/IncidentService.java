package com.hsbc.hometask.incidentmanagement.service;

import com.hsbc.hometask.incidentmanagement.domain.entity.Incident;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IncidentService {

    private final Map<UUID, Incident> incidentStore = new ConcurrentHashMap<>();

    public Incident createIncident(Incident incident) {
        if (incidentStore.containsKey(incident.getId())) {
            throw new IllegalArgumentException("Incident already exists");
        }
        incidentStore.put(incident.getId(), incident);
        return incident;
    }

    public Incident getIncidentById(UUID id) {
        return Optional.ofNullable(incidentStore.get(id))
                .orElseThrow(() -> new NoSuchElementException("Incident not found"));
    }

    public List<Incident> getAllIncidents() {
        return new ArrayList<>(incidentStore.values());
    }

    public Incident updateIncident(UUID id, Incident newIncident) {
        Incident existingIncident = getIncidentById(id);
        existingIncident.setTitle(newIncident.getTitle());
        existingIncident.setDescription(newIncident.getDescription());
        existingIncident.setStatus(newIncident.getStatus());
        return existingIncident;
    }

    public void deleteIncident(UUID id) {
        if (incidentStore.remove(id) == null) {
            throw new NoSuchElementException("Incident not found");
        }
    }
}
