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

insert into TipoNovedad(tipo) values ('REGISTRAR');
insert into TipoNovedad(tipo) values ('CONSULTAR');

insert into Rol(tipo) values ('ESTUDIANTE');               
insert into Rol(tipo) values ('ADMINISTRATIVO');

insert into Usuario(carnet, nombre, correo, contrasena, estado, rol) values ('2123238', 'Carlos', 'carlos.amorocho@mail.escuelaing.edu.co', 'carlitos', 'Activo', 'ADMINISTRATIVO');
insert into Usuario(carnet, nombre, correo, contrasena, estado, rol) values ('2154957', 'Daniela', 'angie.ruiz@mail.escuelaing.edu.co', 'snowball', 'Activo', 'ESTUDIANTE');
insert into Usuario(carnet, nombre, correo, contrasena, estado, rol) values ('1234567', 'prueba', 'prueba@pruebita.com', 'prueba', 'Activo', 'ADMINISTRATIVO');

insert into Laboratorio(nombre, capacidad, disponible) values ('Ing. Software', 20, True);
insert into Laboratorio(nombre, capacidad, disponible) values ('Lab. Redes', 15, True);
insert into Laboratorio(nombre, capacidad, disponible) values ('Lab. Ingenio', 20, False);

insert into Equipo(nombre, disponible) values ('Computador', False);
insert into Equipo(nombre, disponible) values ('Portatil', False);
insert into Equipo(nombre, disponible) values ('Computador', True);

insert into Novedad(fecha, carnet, idlaboratorio, idequipo, descripcion, tiponovedad) values ('2020-05-25', 2123238, 1, 1, 'Se registro el equipo al lab', 'REGISTRAR');
insert into Novedad(fecha, carnet, idlaboratorio, idequipo, descripcion, tiponovedad) values ('2020-06-25', 2154957, 2, 2, 'Se registro el equipo al lab', 'CONSULTAR');
insert into Novedad(fecha, carnet, idlaboratorio, idequipo, descripcion, tiponovedad) values ('2020-07-25', 1234567, 3, 1, 'Se registro el equipo al lab', 'REGISTRAR');

insert into Elemento(nombre, fabricante, disponible) values ('Torre', 'HP', True);
insert into Elemento(nombre, fabricante, disponible) values ('Pantalla', 'HP', True);
insert into Elemento(nombre, fabricante, disponible) values ('Mouse', 'HP', True);
insert into Elemento(nombre, fabricante, disponible) values ('Teclado', 'HP', True);

insert into Equipos(idlaboratorio, idequipo) values (1, 1);
insert into Equipos(idlaboratorio, idequipo) values (2, 2);

insert into Elementos(idequipo, idelemento) values (1, 1);
insert into Elementos(idequipo, idelemento) values (1, 2);
insert into Elementos(idequipo, idelemento) values (2, 1);
insert into Elementos(idequipo, idelemento) values (2, 3);

drop table Elemento cascade;
drop table Equipo cascade;
drop table Elementos cascade;
drop table Equipos cascade;
drop table Laboratorio cascade;
drop table Rol cascade;
drop table Usuario cascade;
drop table TipoNovedad cascade;
drop table Novedad cascade;

-- Consultas 

-- Equipos de un laboratorio --
SELECT
equipo.id,
equipo.nombre
FROM laboratorio, equipos, equipo
WHERE laboratorio.id = 1 AND 1 = equipos.idlaboratorio and equipos.idequipo = equipo.id;
-------------------------------
-- Un laboratorio con equipos --
INSERT INTO laboratorio(nombre, capacidad, disponible)
values ('Lab. Hacking', 14, True);
INSERT INTO equipo(nombre, disponible)
VALUES ('Computador', False);
INSERT INTO equipo(nombre, disponible)
VALUES ('Portatil', False);
INSERT INTO equipos(idlaboratorio, idequipo)
SELECT	MAX(laboratorio.id), MAX(equipo.id) 
FROM laboratorio, equipo;

select * from laboratorio;
select * from equipo;
select * from equipos;


