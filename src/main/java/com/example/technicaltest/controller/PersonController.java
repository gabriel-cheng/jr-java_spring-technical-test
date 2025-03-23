package com.example.technicaltest.controller;

import java.util.List;
import java.util.Optional;
import com.example.technicaltest.domain.vehicle.VehicleRepository;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicaltest.domain.person.Person;
import com.example.technicaltest.domain.person.PersonRepository;
import com.example.technicaltest.domain.person.RequestPerson;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final VehicleRepository vehicleRepository;
    
    @Autowired
    private PersonRepository personRepository;

    PersonController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> person = personRepository.findAll();

        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getOnePerson(@PathVariable String id) {
        Optional<Person> personFinded = personRepository.findById(id);

        return ResponseEntity.ok(personFinded);
    }

    @PostMapping
    public ResponseEntity<String> registerNewPerson(@RequestBody @Validated RequestPerson person) {
        Person newPerson = new Person(person);

        personRepository.save(newPerson);

        return ResponseEntity.ok("New person created!");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@RequestParam String id) {
        personRepository.deleteById(id);

        return ResponseEntity.ok("Person successfully deleted!");   
    }
}
