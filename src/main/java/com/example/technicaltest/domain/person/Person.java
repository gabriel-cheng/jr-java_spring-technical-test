package com.example.technicaltest.domain.person;

import java.util.ArrayList;
import java.util.List;

import com.example.technicaltest.domain.vehicle.Vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private String personId;
    
    private String name;

    private String cpf;

    private int age;

    private String genre;

    private String email;

    private String cellphone;

    @OneToMany(mappedBy = "person")
    private List<Vehicle> vehicle = new ArrayList<>();

    public Person(RequestPerson requestPerson) {
        this.name = requestPerson.name();
        this.cpf = requestPerson.cpf();
        this.age = requestPerson.age();
        this.genre = requestPerson.genre();
        this.email = requestPerson.email();
        this.cellphone = requestPerson.cellphone();
    }
}
