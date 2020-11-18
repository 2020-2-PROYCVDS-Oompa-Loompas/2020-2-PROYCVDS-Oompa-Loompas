package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioMapper 
{
	public Laboratorio getLaboratorio(@Param("id") int id);
	public void agregarLaboratorio(@Param("id") int id, @Param("nombre") String nombre, @Param("capacidad") int capacidad);
}
