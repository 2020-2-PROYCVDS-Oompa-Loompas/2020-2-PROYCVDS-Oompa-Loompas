package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Elemento;

public interface ElementoMapper 
{
	public Elemento getElemento(@Param("id") int id);
	public void agregarElemento(@Param("id") int id, @Param("fabricante") String fabricante, @Param("idequipo") int idequipo, @Param("disponible") boolean disponible, @Param("nombre") String nombre);	
}
