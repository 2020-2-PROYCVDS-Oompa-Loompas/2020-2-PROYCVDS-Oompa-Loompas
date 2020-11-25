package edu.eci.cvds.servicios;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ServiciosLab 
{      
   public Laboratorio getLaboratorioPorNombre(String nombre) throws ExcepcionServiciosLab;
   
   public void agregarLaboratorio(String nombre, int capacidad, LocalDate fechacreacion, LocalDate fechacierre) throws ExcepcionServiciosLab, PersistenceException;
   
   public List<Laboratorio> getLaboratorios() throws ExcepcionServiciosLab;
   
   public List<Laboratorio> getLaboratoriosDisponibles() throws ExcepcionServiciosLab;
   
   public List<Equipo> getEquiposLaboratorio(String nombre) throws ExcepcionServiciosLab;
   
   public void asociarEquipo(String nombre) throws ExcepcionServiciosLab, PersistenceException;
   
   public void cerrarLaboratorio(String nombre, LocalDate fechacierre) throws ExcepcionServiciosLab;
}