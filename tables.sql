
CREATE TABLE IF NOT EXISTS Rol(tipo VARCHAR(14) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Usuario(carnet VARCHAR(50) PRIMARY KEY, nombre VARCHAR(50) NOT NULL, correo VARCHAR(50), contrasena VARCHAR(80) NOT NULL, estado VARCHAR(15) NOT NULL, rol VARCHAR(14) REFERENCES Rol(tipo));

CREATE TABLE IF NOT EXISTS TipoNovedad(tipo VARCHAR(14) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Laboratorio(id SERIAL PRIMARY KEY, nombre VARCHAR(15) unique, capacidad BIGINT, disponible BOOLEAN,fechacreacion DATE, fechacierre DATE);

CREATE TABLE IF NOT EXISTS Equipo(id SERIAL PRIMARY KEY, nombre VARCHAR(15) unique, disponible BOOLEAN, funcionamiento BOOLEAN, laboratorio VARCHAR(15) references Laboratorio(nombre));

--CREATE TABLE IF NOT EXISTS Equipos(idlaboratorio INT not NULL, idEquipo INT not null);

--ALTER TABLE Equipos ADD CONSTRAINT PK_Equipos PRIMARY KEY (idlaboratorio, idEquipo);
--alter table Equipos add constraint FK_equipos_Lab foreign key (idlaboratorio) REFERENCES Laboratorio(id);
--alter table Equipos add constraint FK_equipos_equi foreign key (idEquipo) REFERENCES Equipo(id);

CREATE TABLE IF NOT EXISTS Elemento(id SERIAL PRIMARY KEY, categoria VARCHAR(100), fabricante VARCHAR(15), disponible BOOLEAN, funcionamiento BOOLEAN, equipo VARCHAR(50) references Equipo (nombre));

CREATE TABLE IF NOT EXISTS Novedad(id SERIAL PRIMARY KEY, fecha DATE, carnet VARCHAR(50) references Usuario(carnet), idEquipo INT references Equipo(id), idelemento INT references Elemento(id), descripcion VARCHAr(100), tiponovedad VARCHAR(15) REFERENCES TipoNovedad(tipo));