package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioMapper 
{	
	public Laboratorio getLaboratorioPorNombre(@Param("nombre") String nombre);
	
	public void agregarLaboratorio(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("fechacreacion") LocalDate fechacreacion, @Param("fechacierre") LocalDate fechacierre);
	
	public List<Laboratorio> getLaboratorios();
	
	public List<Laboratorio> getLaboratoriosDisponibles();
	
	public List<Equipo> getEquiposLaboratorio(@Param("nombre") String nombre);
	
	public void asociarEquipo(@Param("nombre") String nombre);
	
	public void cerrarLaboratorio(@Param("nombre") String nombre, @Param("fechacierre") LocalDate fechacierre);
}
