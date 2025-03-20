package com.example.technicaltest.domain.vehicle;

import com.example.technicaltest.domain.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(of="vehicleId")
public class Vehicle {
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="vehicleid")
    private String vehicleId;

    private String brand;

    private String model;

    private String color;

    private String plate;

    private double price;

    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;

    public Vehicle(RequestVehicle requestVehicle) {
        this.brand = requestVehicle.brand();
        this.model = requestVehicle.model();
        this.color = requestVehicle.color();
        this.plate = requestVehicle.plate();
        this.price = requestVehicle.price();
        this.person = requestVehicle.person();
    }
}