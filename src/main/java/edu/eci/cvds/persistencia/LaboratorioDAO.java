package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioDAO
{
	public Laboratorio getLaboratorio(int id);
	
	public void agregarLaboratorio(String nombre, int capacidad, boolean disponible) throws PersistenceException;
	
	public List<Laboratorio> getLaboratorios();
	
	public List<Laboratorio> getLaboratoriosDisponibles();
	
	public List<Equipo> getEquiposLaboratorio(int id);
}
