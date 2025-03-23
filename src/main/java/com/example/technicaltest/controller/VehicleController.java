package com.example.technicaltest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicaltest.domain.vehicle.Vehicle;
import com.example.technicaltest.domain.vehicle.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public ResponseEntity<String> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleRepository.findAll();

        return ResponseEntity.ok("Ok");
    }
}
