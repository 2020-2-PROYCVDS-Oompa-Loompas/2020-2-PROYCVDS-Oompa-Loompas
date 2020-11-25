package edu.eci.cvds.persistencia;

import java.time.LocalDate;
import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioDAO
{	
	public Laboratorio getLaboratorioPorNombre(String nombre);
	
	public void agregarLaboratorio(String nombre, int capacidad, LocalDate fechacreacion, LocalDate fechacierre) throws PersistenceException;
	
	public List<Laboratorio> getLaboratorios();
	
	public List<Laboratorio> getLaboratoriosDisponibles();
	
	public List<Equipo> getEquiposLaboratorio(String nombre);
	
	public void asociarEquipo(String nombre) throws PersistenceException;
	
	public void cerrarLaboratorio(String nombre, LocalDate fechacierre);
}
