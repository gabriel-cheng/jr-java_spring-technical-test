package com.example.technicaltest.domain.vehicle;

public record RequestVehicle(
    String brand,
    String model,
    String color,
    String plate,
    double price,
    String personid
) {}
