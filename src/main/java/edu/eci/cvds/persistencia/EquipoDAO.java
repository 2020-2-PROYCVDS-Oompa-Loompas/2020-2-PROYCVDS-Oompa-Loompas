package edu.eci.cvds.persistencia;

import edu.eci.cvds.entities.Equipo;

public interface EquipoDAO 
{
	public Equipo getEquipo(int id);
	
	public void agregarEquipo(String nombre, boolean disponible) throws PersistenceException;
}
