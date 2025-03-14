package com.example.technicaltest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class AutomobileController {
    
    @GetMapping
    public ResponseEntity<String> getAllCars() {
        return ResponseEntity.ok("ataaaa");
    }
}
