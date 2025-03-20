CREATE TABLE person (
    personId TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    cpf TEXT NOT NULL,
    age INT NOT NULL,
    genre TEXT NOT NULL,
    email TEXT NOT NULL,
    cellphone TEXT NOT NULL
);

CREATE TABLE vehicle (
    vehicleId TEXT PRIMARY KEY NOT NULL,
    brand TEXT NOT NULL,
    model TEXT NOT NULL,
    color TEXT NOT NULL,
    plate TEXT NOT NULL,
    price FLOAT NOT NULL,
    personId TEXT NOT NULL,
    CONSTRAINT fk_person FOREIGN KEY (personId)
    REFERENCES person(personId)
);