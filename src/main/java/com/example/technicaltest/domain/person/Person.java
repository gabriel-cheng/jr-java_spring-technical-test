package com.example.technicaltest.domain.person;

import java.util.ArrayList;
import java.util.List;

import com.example.technicaltest.domain.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="person")
@Entity(name="person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="personId")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="personid")
    private String personId;
    
    private String name;

    private String cpf;

    private int age;

    private String genre;

    private String email;

    private String cellphone;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"person"})
    private List<Vehicle> vehicles = new ArrayList<>();

    public Person(RequestPerson requestPerson) {
        this.name = requestPerson.name();
        this.cpf = requestPerson.cpf();
        this.age = requestPerson.age();
        this.genre = requestPerson.genre();
        this.email = requestPerson.email();
        this.cellphone = requestPerson.cellphone();
    }
}
