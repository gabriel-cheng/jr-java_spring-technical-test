package com.example.technicaltest.domain.person;

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

@Table(name="person")
@Entity(name="person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String person_id;
    
    private String name;

    private String cpf;

    private int age;

    private String genre;

    private String email;

    private String cellphone;

    public Person(RequestPerson requestPerson) {
        this.name = requestPerson.name();
        this.cpf = requestPerson.cpf();
        this.age = requestPerson.age();
        this.genre = requestPerson.genre();
        this.email = requestPerson.email();
        this.cellphone = requestPerson.cellphone();
    }
}
