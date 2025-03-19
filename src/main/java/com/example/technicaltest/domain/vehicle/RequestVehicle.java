package com.example.technicaltest.domain.vehicle;

import com.example.technicaltest.domain.person.Person;

public record RequestVehicle(
    String brand,
    String model,
    String color,
    String plate,
    double price,
    Person person
) {}
