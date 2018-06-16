create table user (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  deporte VARCHAR(255) NOT NULL,
  tipo ENUM('Atleta', 'Coach') NOT NULL
);