package edu.eci.cvds.persistencia;

import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioDAO
{
	public Laboratorio getLaboratorio(int id);
	
	public void agregarLaboratorio(int id, String nombre, int capacidad) throws PersistenceException;
}
