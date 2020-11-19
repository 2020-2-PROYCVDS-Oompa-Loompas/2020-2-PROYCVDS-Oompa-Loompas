package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Elemento;

public interface ElementoMapper 
{
	public Elemento getElemento(@Param("id") int id);
	public void agregarElemento(@Param("nombre") String nombre, @Param("fabricante") String fabricante, @Param("disponible") boolean disponible);	
}
