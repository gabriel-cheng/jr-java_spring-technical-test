package com.example.technicaltest.controller;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicaltest.domain.person.Person;
import com.example.technicaltest.domain.person.PersonRepository;
import com.example.technicaltest.domain.vehicle.RequestVehicle;
import com.example.technicaltest.domain.vehicle.Vehicle;
import com.example.technicaltest.domain.vehicle.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleRepository.findAll();

        return ResponseEntity.ok(allVehicles);
    }

    @PostMapping
    public ResponseEntity<String> registerNewVehicle(@RequestBody @Validated RequestVehicle vehicle) {
        Optional<Person> personFinded = personRepository.findById(vehicle.personid());

        if(!personFinded.isPresent()) {
            return new ResponseEntity<>("Person not found!", HttpStatus.NOT_FOUND);
        }

        Vehicle newVehicle = new Vehicle(vehicle);
        newVehicle.setPerson(personFinded.get());

        vehicleRepository.save(newVehicle);

        return new ResponseEntity<>("New vehicle added successfully!", HttpStatus.CREATED);
    }
}
