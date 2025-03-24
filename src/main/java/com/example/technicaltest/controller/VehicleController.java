package com.example.technicaltest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> getOneVehicle(@PathVariable String id) {
        Optional<Vehicle> vehicleFinded = vehicleRepository.findById(id);

        if(!vehicleFinded.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehicleFinded, HttpStatus.OK);
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

    @PutMapping("/{id}")
    public ResponseEntity<String> changeVehicle(@PathVariable @Validated String id, @RequestBody RequestVehicle data) {
        Optional<Vehicle> vehicleFinded = vehicleRepository.findById(id);
        Optional<Person> personFinded = personRepository.findById(data.personid());

        if(!vehicleFinded.isPresent()) {
            return new ResponseEntity<>("Vehicle not found!", HttpStatus.NOT_FOUND);
        }
        if(!personFinded.isPresent()) {
            return new ResponseEntity<>("Person not found!", HttpStatus.NOT_FOUND);
        }

        Vehicle vehicle = vehicleFinded.get();
        vehicle.setBrand(data.brand());
        vehicle.setModel(data.model());
        vehicle.setColor(data.color());
        vehicle.setPlate(data.plate());
        vehicle.setPrice(data.price());
        vehicle.setPerson(personFinded.get());

        vehicleRepository.save(vehicle);

        return new ResponseEntity<>("Changes applied successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String id) {
        Optional<Vehicle> vehicleFinded = vehicleRepository.findById(id);

        if(!vehicleFinded.isPresent()) {
            return new ResponseEntity<>("Vehicle not found!", HttpStatus.NOT_FOUND);
        }

        vehicleRepository.deleteById(id);

        return new ResponseEntity<>("Vehicle deleted successfully!", HttpStatus.ACCEPTED);
    }
}
