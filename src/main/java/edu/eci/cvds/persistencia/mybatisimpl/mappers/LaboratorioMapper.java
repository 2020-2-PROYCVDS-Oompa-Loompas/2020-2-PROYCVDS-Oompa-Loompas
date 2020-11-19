package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioMapper 
{
	public Laboratorio getLaboratorio(@Param("id") int id);
	
	public void agregarLaboratorio(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("disponible") boolean disponible);
	
	public List<Laboratorio> getLaboratorios();
	
	public List<Laboratorio> getLaboratoriosDisponibles();
	
	public List<Equipo> getEquiposLaboratorio(@Param("id") int id);
}
