package edu.eci.cvds.persistencia;

import edu.eci.cvds.entities.Elemento;

public interface ElementoDAO
{
	public Elemento getElemento(int id);
	
	public void agregarElemento(int id, String fabricante, int idequipo, boolean disponible, String nombre) throws PersistenceException;
}
