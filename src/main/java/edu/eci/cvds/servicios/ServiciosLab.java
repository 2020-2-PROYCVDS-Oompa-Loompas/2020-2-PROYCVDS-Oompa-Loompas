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

import org.apache.ibatis.annotations.Param;

public interface ServiciosLab {

   public abstract Usuario consultarUsuarioLog(int carnet, String contrasena) throws PersistenceException;

   public abstract List<Usuario> consultarUsuarios() throws PersistenceException;
   
   public abstract Novedad getNovedad(int id);	
   
   public abstract List<Novedad> getNovedades();
   
   public abstract void agregarNovedad(LocalDate fecha, int carnet, int idlaboratorio, int idequipo, String descripcion, TipoNovedad tiponovedad);
   
   public abstract Laboratorio getLaboratorio(int id);
   
   public abstract void agregarLaboratorio(String nombre, int capacidad, boolean disponible);
   
   public abstract List<Laboratorio> getLaboratorios();
   
   public abstract List<Laboratorio> getLaboratoriosDisponibles();
   
   public abstract List<Equipo> getEquiposLaboratorio(int id);
   
   public abstract Equipo getEquipo(int id);
   
   public abstract void agregarEquipo(String nombre, boolean disponible);
   
   public abstract Elemento getElemento(int id);
   
   public abstract void agregarElemento(String nombre, String fabricante, boolean disponible);

   
}