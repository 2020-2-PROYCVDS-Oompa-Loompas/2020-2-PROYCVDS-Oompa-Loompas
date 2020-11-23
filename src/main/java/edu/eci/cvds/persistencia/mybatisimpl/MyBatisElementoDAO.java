package edu.eci.cvds.persistencia.mybatisimpl;

import java.util.List;

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
	public List<Elemento> getElementos()
	{
		return mapper.getElementos();
	}
	
	@Override
	public List<Elemento> getElementoOrdenadoPorId()
	{
		return mapper.getElementoOrdenadoPorId();
	}
	
	@Override
	public List<Elemento> getElementoOrdenadoPorCategoria()
	{
		return mapper.getElementoOrdenadoPorCategoria();
	}
	
	@Override
	public List<Elemento> getElementoOrdenadoPorFabricante()
	{
		return mapper.getElementoOrdenadoPorFabricante();
	}
	
	@Override
	public List<Elemento> getElementoOrdenadoPorDisponible() 
	{
		return mapper.getElementoOrdenadoPorDisponible();
	}
	
	@Override
	public List<Elemento> getElementoOrdenadoPorIdEquipo()
	{
		return mapper.getElementoOrdenadoPorIdEquipo();
	}
	
	@Override
	public void agregarElemento(String nombre, String fabricante, boolean disponible, int idequipo) throws PersistenceException
	{
		if(!(nombre != "Torre" || nombre != "Pantalla" || nombre != "Mouse" || nombre != "Teclado"))
		{
			throw new PersistenceException("Categoria Erronea");
		}
		else
		{
			mapper.agregarElemento(nombre, fabricante, disponible, idequipo);
		}	
	}
	
	@Override
	public List<Elemento> getElementosDisponibles()
	{
		return mapper.getElementosDisponible();
	}
	
	@Override
	public List<Elemento> getElementosPorCategoria(String categoria)
	{
		return mapper.getElementosPorCategoria(categoria);
	}
	
	@Override
	public List<Elemento> getElementosPorFabricante(String fabricante)
	{
		return mapper.getElementosPorFabricante(fabricante);
	}
	
	@Override
	public void asociarElemento(int id) throws PersistenceException
	{
		if(!getElemento(id).getDisponible())
		{
			throw new PersistenceException("No puedes asociar un elemento no disponible");
		}
		else
		{
			mapper.asociarElemento(id);
		}
	}
	
	@Override
	public void bajarElemento(int id) throws PersistenceException
	{
		if(getElemento(id).getIdEquipo() != 0)
		{
			throw new PersistenceException("No puedes dar de baja a un elemento asociado con un equipo");
		}
		else
		{
			mapper.bajarElemento(id);
		}
	}
}
