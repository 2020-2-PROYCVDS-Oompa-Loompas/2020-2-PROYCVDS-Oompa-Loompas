package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Equipo;

public interface EquipoMapper 
{
	public Equipo getEquipo(@Param("id") int id);
	
	public void agregarEquipo(@Param("nombre") String nombre, @Param("disponible") boolean disponible);
}
