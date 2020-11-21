CREATE TABLE IF NOT EXISTS Rol(tipo VARCHAR(14) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Usuario(carnet VARCHAR(30) PRIMARY KEY, nombre VARCHAR(50) NOT NULL, correo VARCHAR(50), contrasena VARCHAR(80) NOT NULL, estado VARCHAR(15) NOT NULL, rol VARCHAR(14) REFERENCES Rol(tipo));

CREATE TABLE IF NOT EXISTS TipoNovedad(tipo VARCHAR(14) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Laboratorio(id SERIAL PRIMARY KEY, nombre VARCHAR(15), capacidad BIGINT, disponible BOOLEAN);

CREATE TABLE IF NOT EXISTS Equipo(id SERIAL PRIMARY KEY, nombre VARCHAR(15), disponible BOOLEAN);

CREATE TABLE IF NOT EXISTS Equipos(idlaboratorio INT not NULL, idEquipo INT not null);

ALTER TABLE Equipos ADD CONSTRAINT PK_Equipos PRIMARY KEY (idlaboratorio, idEquipo);
alter table Equipos add constraint FK_equipos_Lab foreign key (idlaboratorio) REFERENCES Laboratorio(id);
alter table Equipos add constraint FK_equipos_equi foreign key (idEquipo) REFERENCES Equipo(id);

CREATE TABLE IF NOT EXISTS Novedad(id SERIAL PRIMARY KEY, fecha DATE, carnet VARCHAR(30) references Usuario(carnet), idLaboratorio INT references Laboratorio(id), idEquipo INT references Equipo(id), descripcion VARCHAr(100), tiponovedad VARCHAR(15) REFERENCES TipoNovedad(tipo));

CREATE TABLE IF NOT EXISTS Elemento(id SERIAL PRIMARY KEY, nombre VARCHAR(100), fabricante VARCHAR(15), disponible BOOLEAN);

CREATE TABLE IF NOT EXISTS Elementos (id SERIAL PRIMARY KEY, idequipo INT REFERENCES Equipo (id), idelemento INT REFERENCES Elemento (id));
