package com.example.technicaltest.domain.person;

public record RequestPerson(
    String name,
    String cpf,
    int age,
    String genre,
    String email,
    String cellphone
) { }