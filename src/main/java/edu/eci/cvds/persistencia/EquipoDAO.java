package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entities.Equipo;

public interface EquipoDAO 
{
	public Equipo getEquipo(int id);
	
	public void agregarEquipo(String nombre, boolean disponible, int idlaboratorio) throws PersistenceException;
	
	public List<Equipo> getEquiposDisponibles();
	
	public void asociarEquipo(int id) throws PersistenceException;
}
