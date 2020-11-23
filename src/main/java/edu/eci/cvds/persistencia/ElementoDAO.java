package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entities.Elemento;

public interface ElementoDAO
{
	public Elemento getElemento(int id);
	
	public List<Elemento> getElementos();
	
	public List<Elemento> getElementoOrdenadoPorId();
	
	public List<Elemento> getElementoOrdenadoPorCategoria();
	
	public List<Elemento> getElementoOrdenadoPorFabricante();
	
	public List<Elemento> getElementoOrdenadoPorDisponible();
	
	public List<Elemento> getElementoOrdenadoPorIdEquipo();
	
	public void agregarElemento(String nombre, String fabricante, boolean disponible, int idequipo) throws PersistenceException;
	
	public List<Elemento> getElementosDisponibles();
	
	public List<Elemento> getElementosPorCategoria(String categoria);
	
	public List<Elemento> getElementosPorFabricante(String fabricante);
	
	public void asociarElemento(int id) throws PersistenceException;
}
