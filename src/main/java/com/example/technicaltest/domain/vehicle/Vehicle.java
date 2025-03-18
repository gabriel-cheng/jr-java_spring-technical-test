package com.example.technicaltest.domain.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="vehicle")
@Entity(name="vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="vehicle_id")
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicle_id;

    private String brand;

    private String model;

    private String color;

    private String plate;

    private long price;

    public Vehicle(RequestVehicle requestVehicle) {
        this.brand = requestVehicle.brand();
        this.model = requestVehicle.model();
        this.color = requestVehicle.color();
        this.plate = requestVehicle.plate();
        this.price = requestVehicle.price();
    }
}