package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistencia.ElementoDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.ElementoMapper;

public class MyBatisElementoDAO implements ElementoDAO
{
	@Inject
	private ElementoMapper mapper;
	
	@Override
	public Elemento getElemento(int id)
	{
		return mapper.getElemento(id);
	}
	
	@Override
	public void agregarElemento(int id, String fabricante, int idequipo, boolean disponible, String nombre) throws PersistenceException
	{
		if(getElemento(id)!= null)
		{
			throw new PersistenceException("Ya existe un Elemento con esta id");
		}
		else if(!(nombre != "Torre" || nombre != "Pantalla" || nombre != "Mouse" || nombre != "Teclado"))
		{
			throw new PersistenceException("Categoria Erronea");
		}
		else
		{
			mapper.agregarElemento(id, fabricante, idequipo, disponible, nombre);
		}
		
	}
}
