CREATE TABLE IF NOT EXISTS Rol(tipo VARCHAR(14) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Usuario(carnet VARCHAR(50) PRIMARY KEY, nombre VARCHAR(50) NOT NULL, correo VARCHAR(50), contrasena VARCHAR(80) NOT NULL, estado VARCHAR(15) NOT NULL, rol VARCHAR(14) REFERENCES Rol(tipo));

CREATE TABLE IF NOT EXISTS TipoNovedad(tipo VARCHAR(14) PRIMARY KEY);

CREATE TABLE IF NOT EXISTS Laboratorio(id SERIAL PRIMARY KEY, nombre VARCHAR(15) unique, capacidad BIGINT, fechacreacion DATE, fechacierre DATE);

CREATE TABLE IF NOT EXISTS Equipo(id SERIAL PRIMARY KEY, nombre VARCHAR(15), disponible BOOLEAN, funcionamiento BOOLEAN, laboratorio VARCHAR(15) references Laboratorio(nombre));

--CREATE TABLE IF NOT EXISTS Equipos(idlaboratorio INT not NULL, idEquipo INT not null);

--ALTER TABLE Equipos ADD CONSTRAINT PK_Equipos PRIMARY KEY (idlaboratorio, idEquipo);
--alter table Equipos add constraint FK_equipos_Lab foreign key (idlaboratorio) REFERENCES Laboratorio(id);
--alter table Equipos add constraint FK_equipos_equi foreign key (idEquipo) REFERENCES Equipo(id);

CREATE TABLE IF NOT EXISTS Elemento(id SERIAL PRIMARY KEY, categoria VARCHAR(100), fabricante VARCHAR(15), disponible BOOLEAN, funcionamiento BOOLEAN, idequipo INT references Equipo (id));

CREATE TABLE IF NOT EXISTS Novedad(id SERIAL PRIMARY KEY, fecha DATE, carnet VARCHAR(50) references Usuario(carnet), idEquipo INT references Equipo(id), idelemento INT references Elemento(id), descripcion VARCHAr(100), tiponovedad VARCHAR(15) REFERENCES TipoNovedad(tipo));
--CREATE TABLE IF NOT EXISTS Elementos (id SERIAL PRIMARY KEY, idequipo INT REFERENCES Equipo (id), idelemento INT REFERENCES Elemento (id));

insert into TipoNovedad(tipo) values ('REGISTRAR');
insert into TipoNovedad(tipo) values ('CONSULTAR');
insert into TipoNovedad(tipo) values ('DAR_DE_BAJA');
insert into TipoNovedad(tipo) values ('ELIMINAR');

insert into Rol(tipo) values ('ESTUDIANTE');               
insert into Rol(tipo) values ('ADMINISTRATIVO');

insert into Usuario(carnet, nombre, correo, contrasena, estado, rol) values ('2123238', 'Carlos', 'carlos.amorocho@mail.escuelaing.edu.co', 'carlitos', 'Activo', 'ADMINISTRATIVO');
insert into Usuario(carnet, nombre, correo, contrasena, estado, rol) values ('2154957', 'Daniela', 'angie.ruiz@mail.escuelaing.edu.co', 'snowball', 'Activo', 'ESTUDIANTE');
insert into Usuario(carnet, nombre, correo, contrasena, estado, rol) values ('1234567', 'prueba', 'prueba@pruebita.com', 'prueba', 'Activo', 'ADMINISTRATIVO');

insert into Laboratorio(nombre, capacidad, fechacreacion, fechacierre) values ('Ing. Software', 20, '1996-05-25', null);
insert into Laboratorio(nombre, capacidad, fechacreacion, fechacierre) values ('Lab. Redes', 15, '1996-07-25', null);
insert into Laboratorio(nombre, capacidad, fechacreacion, fechacierre) values ('Lab. Ingenio', 20, '1996-05-25', '2018-05-25');

insert into Equipo(nombre, disponible, funcionamiento, laboratorio) values ('Computador 1', false, true, 'Ing. Software');
insert into Equipo(nombre, disponible, funcionamiento, laboratorio) values ('Computador 2', false, true, 'Lab. Redes');
insert into Equipo(nombre, disponible, funcionamiento, laboratorio) values ('Computador 3', true, true, null);

insert into Novedad(fecha, carnet, idequipo, idelemento, descripcion, tiponovedad) values ('2020-05-25', '2123238', 1, null, 'Se registro el equipo al lab', 'REGISTRAR');
insert into Novedad(fecha, carnet, idequipo, idelemento,  descripcion, tiponovedad) values ('2020-06-25', '2154957', 2, null, 'Se registro el equipo al lab', 'CONSULTAR');
insert into Novedad(fecha, carnet, idequipo, idelemento,  descripcion, tiponovedad) values ('2020-07-25', '1234567', 1, null, 'Se registro el equipo al lab', 'REGISTRAR');

insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Torre', 'HP', false, true, 1);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Pantalla', 'HP', false, true, 1);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Mouse', 'HP', false, true, 1);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Teclado', 'HP', false, true, 1);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Torre', 'Microsoft', false, true, 2);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Pantalla', 'Microsoft', false, true, 2);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Mouse', 'Microsoft', false, true, 2);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Teclado', 'Microsoft', false, true, 2);
insert into Elemento(categoria, fabricante, disponible, funcionamiento, idequipo) values ('Teclado', 'Genius', true, true, null);

--insert into Equipos(idlaboratorio, idequipo) values (1, 1);
--insert into Equipos(idlaboratorio, idequipo) values (2, 2);

--insert into Elementos(idequipo, idelemento) values (1, 1);
--insert into Elementos(idequipo, idelemento) values (1, 2);
--insert into Elementos(idequipo, idelemento) values (2, 1);
--insert into Elementos(idequipo, idelemento) values (2, 3);

--- Disparadores ---------------------------------------
CREATE OR REPLACE FUNCTION funcionFecha() RETURNS trigger AS
$$
BEGIN
	NEW.fechacreacion:= current_date;
	RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER tb_fecha_inicio
BEFORE INSERT ON public.laboratorio 
FOR EACH ROW
EXECUTE PROCEDURE funcionFecha();

CREATE OR REPLACE FUNCTION funcionFechaNovedad() RETURNS trigger AS
$$
BEGIN
	NEW.fecha:= current_date;
	RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';
CREATE TRIGGER tb_fecha_novedad
BEFORE INSERT ON public.novedad
FOR EACH ROW
EXECUTE PROCEDURE funcionFechaNovedad();

-- Consultas --------------------------------------------
select * from TipoNovedad;
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
select * from elemento;

-- Asociar un equipo ------------------------
  		UPDATE equipo SET disponible = False, idlaboratorio = 1
  		WHERE id = 3 AND disponible = True;

 -- Elemento disponible ---------------------
   		SELECT
  		*
  		FROM elemento
  		WHERE disponible = True;

--- Asociar elemento ------------------------
select * from elemento;

   		UPDATE elemento SET disponible = False, idequipo = #{idequipo}
  		WHERE id = #{id} AND disponible = True;
  	
--- Equipos del lab --------------------------
		SELECT
		equipo.id,
		equipo.nombre
		FROM laboratorio, equipo
		WHERE laboratorio.id = 1 AND 1 = equipo.idlaboratorio;

--- Reporte de novedades ----------------------
		SELECT
 		a.id,
 		a.fecha,
 		a.carnet,
 		a.usuario,
 		a.idlaboratorio,
 		a.idequipo,
 		a.descripcion,
 		a.tiponovedad
 		FROM novedad as a
 		order by a.fecha DESC;

--- Bajar Elemento ----------------------------------
  		UPDATE elemento SET funcionamiento = false, disponible = false
  		WHERE id = 9 AND disponible = True;
  	select * from elemento;

--- Bajar equipo -----------------------------------
  		UPDATE equipo SET disponible = False, funcionamiento = False, idlaboratorio = null
  		WHERE id = 2;
  	select * from equipo;
  
--- Cerrar laboratorio --------------------------------
  		UPDATE laboratorio SET fechacierre = '1996-05-26'
  		WHERE id = 1;
  	select * from laboratorio;
  
--- obtener lab disponibles ---------------------------
  		SELECT
  		id,
  		nombre,
  		capacidad,
  		fechacreacion,
  		fechacierre
  		FROM laboratorio
  		where fechacierre = null ;

--- consultar lab por nombre --------------------------
  		SELECT
  		*
  		FROM laboratorio
  		WHERE nombre = 'Ing. Software';

--- Obtener equipos disponibles -------------------------
  		SELECT
  		*
  		FROM equipo
  		WHERE disponible = True;
  	
--- Consulta del rol --------------------------------
SELECT rol FROM usuario WHERE carnet = '2123238';

--- Actualizar asociaciones ------------------------
  		UPDATE equipo SET disponible = true, laboratorio = (select nombre from laboratorio where id = 1)
  		WHERE id = 3;
  	  		UPDATE equipo SET disponible = true, laboratorio = null
  		WHERE id = 3;
  	select * from laboratorio;
  select * from equipo;
 UPDATE equipo SET laboratorio = null
  		WHERE id = 3;
----------------------------------------------------
  	
drop table Elemento cascade;
drop table Equipo cascade;
drop table Laboratorio cascade;
drop table Rol cascade;
drop table Usuario cascade;
drop table TipoNovedad cascade;
drop table Novedad cascade;
DROP TRIGGER tb_fecha_inicio ON laboratorio;
DROP TRIGGER tb_fecha_novedad ON novedad;
