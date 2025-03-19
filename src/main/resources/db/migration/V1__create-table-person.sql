CREATE TABLE person (
    personId TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    cpf TEXT NOT NULL,
    age INTEGER NOT NULL,
    genre TEXT NOT NULL,
    email TEXT NOT NULL,
    cellphone TEXT NOT NULL
    CONSTRAINT vehicle FOREIGN KEY 
);

CREATE TABLE vehicle (
    vehicleId TEXT PRIMARY KEY NOT NULL,
    brand TEXT NOT NULL,
    model TEXT NOT NULL,
    color TEXT NOT NULL,
    plate TEXT NOT NULL,
    price DOUBLE PRECISION NOT NULL
    CONSTRAINT person FOREIGN KEY(personId) REFERENCES person(personId)
);