package edu.eci.cvds.persistencia;

import java.time.LocalDate;
import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioDAO
{
	public Laboratorio getLaboratorio(int id);
	
	public void agregarLaboratorio(String nombre, int capacidad, LocalDate fechacreacion, LocalDate fechacierre) throws PersistenceException;
	
	public List<Laboratorio> getLaboratorios();
	
	public List<Laboratorio> getLaboratoriosDisponibles();
	
	public List<Equipo> getEquiposLaboratorio(int id);
	
	public void asociarEquipo(int id) throws PersistenceException;
	
	public void cerrarLaboratorio(int id, LocalDate fechacierre);
}
