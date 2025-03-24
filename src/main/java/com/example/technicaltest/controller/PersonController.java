package com.example.technicaltest.controller;

import java.util.List;
import java.util.Optional;
import com.example.technicaltest.domain.vehicle.VehicleRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.aspectj.weaver.patterns.PerObject;
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

        if(!personFinded.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(personFinded);
    }

    @PostMapping
    public ResponseEntity<String> registerNewPerson(@RequestBody @Validated RequestPerson person) {
        Person newPerson = new Person(person);

        personRepository.save(newPerson);

        return new ResponseEntity<>("New person created!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> changePerson(@RequestBody @Validated RequestPerson data, @PathVariable String id) {
        Optional<Person> personFinded = personRepository.findById(id);

        if(!personFinded.isPresent()) {
            return new ResponseEntity<>("Person not found!", HttpStatus.NOT_FOUND);
        }

        Person newPerson = personFinded.get();
        newPerson.setName(data.name());
        newPerson.setCpf(data.cpf());
        newPerson.setAge(data.age());
        newPerson.setGenre(data.genre());
        newPerson.setEmail(data.email());
        newPerson.setCellphone(data.cellphone());

        personRepository.save(newPerson);

        return new ResponseEntity<>("Person changed successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable String id) {
        Optional<Person> personToDelete = personRepository.findById(id);

        if(!personToDelete.isPresent()) {
            return new ResponseEntity<>("Person not found!", HttpStatus.NOT_FOUND);
        }
        
        personRepository.deleteById(id);

        return ResponseEntity.ok("Person deleted successfully!");
    }
}
