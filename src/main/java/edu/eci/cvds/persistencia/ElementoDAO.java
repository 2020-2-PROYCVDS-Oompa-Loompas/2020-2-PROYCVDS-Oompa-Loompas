package edu.eci.cvds.persistencia;

import edu.eci.cvds.entities.Elemento;

public interface ElementoDAO
{
	public Elemento getElemento(int id);
	
	public void agregarElemento(String nombre, String fabricante, boolean disponible) throws PersistenceException;
}
