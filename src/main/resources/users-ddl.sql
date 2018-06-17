create table User (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  nombre VARCHAR(255),
  apellido VARCHAR(255),
  deporte VARCHAR(255),
  tipo ENUM('Atleta', 'Coach')
);