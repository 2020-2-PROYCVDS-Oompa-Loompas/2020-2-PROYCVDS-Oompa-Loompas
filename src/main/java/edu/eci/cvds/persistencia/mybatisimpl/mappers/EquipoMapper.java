package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Equipo;

public interface EquipoMapper 
{
	public Equipo getEquipo(@Param("id") int id);
	
	public List<Equipo> getEquipos();
	
	public void agregarEquipo(@Param("nombre") String nombre, @Param("disponible") boolean disponible, @Param("funcionamiento") boolean funcionamiento, @Param("idlaboratorio") int idlaboratorio);
	
	public List<Equipo> getEquiposDisponibles();
	
	public void asociarEquipo(@Param("id") int idlaboratorio, @Param("idequipo") int idequipo);
	
	public void bajarEquipo(@Param("id") int id);
	
	public void eliminarAsociacion(@Param("idequipo") int idequipo);
}
