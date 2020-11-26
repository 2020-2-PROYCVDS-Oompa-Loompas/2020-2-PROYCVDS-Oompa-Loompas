package edu.eci.cvds.servicios;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistencia.PersistenceException;
import java.util.Date;
import java.util.List;

public interface ServiciosLab 
{      
   public Laboratorio getLaboratorioPorNombre(String nombre) throws ExcepcionServiciosLab;
   
   public void agregarLaboratorio(String nombre, int capacidad) throws ExcepcionServiciosLab, PersistenceException;
   
   public List<Laboratorio> getLaboratorios() throws ExcepcionServiciosLab;
   
   public List<Laboratorio> getLaboratoriosDisponibles() throws ExcepcionServiciosLab;
   
   public List<Equipo> getEquiposLaboratorio(String nombre) throws ExcepcionServiciosLab;
   
   public void asociarEquipo(String nombre) throws ExcepcionServiciosLab, PersistenceException;
   
   public void cerrarLaboratorio(String nombre, Date fechacierre) throws ExcepcionServiciosLab;
}