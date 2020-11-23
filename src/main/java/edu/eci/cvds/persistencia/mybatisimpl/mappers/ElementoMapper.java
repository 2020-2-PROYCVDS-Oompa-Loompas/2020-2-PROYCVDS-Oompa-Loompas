package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Elemento;

public interface ElementoMapper 
{
	public Elemento getElemento(@Param("id") int id);
	
	public List<Elemento> getElementos();
	
	public List<Elemento> getElementoOrdenadoPorId();
	
	public List<Elemento> getElementoOrdenadoPorCategoria();
	
	public List<Elemento> getElementoOrdenadoPorFabricante();
	
	public List<Elemento> getElementoOrdenadoPorDisponible();
	
	public List<Elemento> getElementoOrdenadoPorIdEquipo();
	
	public void agregarElemento(@Param("nombre") String nombre, @Param("fabricante") String fabricante, @Param("disponible") boolean disponible, @Param("idequipo") int idequipo);
	
	public List<Elemento> getElementosDisponible();
	
	public List<Elemento> getElementosPorCategoria(@Param("categoria") String categoria);
	
	public List<Elemento> getElementosPorFabricante(@Param("fabricante") String fabricante);
	
	public void asociarElemento(@Param("id") int id);
	
	public void bajarElemento(@Param("id") int id);
}
