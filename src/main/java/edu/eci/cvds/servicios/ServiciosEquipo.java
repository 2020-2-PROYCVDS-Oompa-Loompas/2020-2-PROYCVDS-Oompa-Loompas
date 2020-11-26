package edu.eci.cvds.servicios;

import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosEquipo 
{
	public Equipo getEquipo(int id) throws ExcepcionServiciosLab;
	
	public List<Equipo> getEquipos() throws ExcepcionServiciosLab;
	   
	public void agregarEquipo(String nombre, boolean disponible, boolean funcionamiento, int idlaboratorio) throws ExcepcionServiciosLab, PersistenceException;
	   
	public List<Equipo> getEquiposDisponibles() throws ExcepcionServiciosLab;
		
	public void asociarEquipoAlLab(int id) throws ExcepcionServiciosLab, PersistenceException;
		
	public void bajarEquipo(int id) throws ExcepcionServiciosLab;
}
