package edu.eci.cvds.servicios.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistencia.ElementoDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.ServiciosElemento;

public class ServiciosECIElementoImpl implements ServiciosElemento
{
	@Inject
	private ElementoDAO elementoDAO;
	
	@Override
	public Elemento getElemento(int id) 
	{
		return elementoDAO.getElemento(id);
	}

	@Override
	public void agregarElemento(String nombre, String fabricante) throws ExcepcionServiciosLab, PersistenceException 
	{
		elementoDAO.agregarElemento(nombre, fabricante);
		
	}

	@Override
	public List<Elemento> getElementos() 
	{
		return elementoDAO.getElementos();
	}

	@Override
	public List<Elemento> getElementoOrdenadoPorId() 
	{
		return elementoDAO.getElementoOrdenadoPorId();
	}

	@Override
	public List<Elemento> getElementoOrdenadoPorCategoria() 
	{
		return elementoDAO.getElementoOrdenadoPorCategoria();
	}

	@Override
	public List<Elemento> getElementoOrdenadoPorFabricante() 
	{
		return elementoDAO.getElementoOrdenadoPorFabricante();
	}

	@Override
	public List<Elemento> getElementoOrdenadoPorDisponible() 
	{
		return elementoDAO.getElementoOrdenadoPorDisponible();
	}

	@Override
	public List<Elemento> getElementoOrdenadoPorIdEquipo() 
	{
		return elementoDAO.getElementoOrdenadoPorIdEquipo();
	}

	@Override
	public List<Elemento> getElementosDisponibles() 
	{
		return elementoDAO.getElementosDisponibles();
	}

	@Override
	public List<Elemento> getElementosPorCategoria(String categoria) 
	{
		return elementoDAO.getElementosPorCategoria(categoria);
	}

	@Override
	public List<Elemento> getElementosPorFabricante(String fabricante) 
	{
		return elementoDAO.getElementosPorFabricante(fabricante);
	}

	@Override
	public void asociarElemento(String nombre, int id) throws ExcepcionServiciosLab
	{
		try {
			elementoDAO.asociarElemento(nombre, id);
		} catch (PersistenceException e) 
		{
			throw new ExcepcionServiciosLab("Errror, no se puede asociar el elemento.");
		}
	}

	@Override
	public void bajarElemento(int id) throws ExcepcionServiciosLab, PersistenceException
	{
		elementoDAO.bajarElemento(id);
	}

	@Override
	public void habilitarElemento(int id) throws ExcepcionServiciosLab, PersistenceException 
	{
		elementoDAO.habilitarElemento(id);
		
	}
}
