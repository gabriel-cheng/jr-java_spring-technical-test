package com.example.technicaltest.domain.vehicle;

public record RequestVehicle(
    String brand,
    String model,
    String color,
    String plate,
    long price
) {}
