package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entities.Equipo;

public interface EquipoDAO 
{
	public Equipo getEquipo(int id);
	
	public List<Equipo> getEquipos();
	
	public void agregarEquipo(String nombre) throws PersistenceException;
	
	public List<Equipo> getEquiposDisponibles();
	
	public List<Equipo> getEquiposLaboratorio(String laboratorio);
	
	public void asociarEquipo(int idlaboratorio, int idequipo) throws PersistenceException;
	
	public void bajarEquipo(int id);
	
	public void eliminarAsociacion(int idequipo);
}
