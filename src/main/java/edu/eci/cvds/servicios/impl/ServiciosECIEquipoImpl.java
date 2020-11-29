package edu.eci.cvds.servicios.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistencia.EquipoDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.servicios.ServiciosEquipo;

public class ServiciosECIEquipoImpl implements ServiciosEquipo
{
	@Inject
	private EquipoDAO equipoDAO;
	
	@Override
	public Equipo getEquipo(int id) 
	{
		return equipoDAO.getEquipo(id);
	}
	
	@Override
	public List<Equipo> getEquipos()
	{
		return equipoDAO.getEquipos();
	}
	
	@Override
	public List<Equipo> getEquiposDisponibles() 
	{
		return equipoDAO.getEquiposDisponibles();
	}

	@Override
	public void agregarEquipo(String nombre) throws PersistenceException
	{
		try 
		{
			equipoDAO.agregarEquipo(nombre);
		} catch (PersistenceException e) 
		{
			throw new PersistenceException("Error al agregar el equipo");
		}
	}
	
	@Override
	public void asociarEquipoAlLab(int idlaboratorio, int idequipo) throws PersistenceException
	{
		try 
		{
			System.out.println(idlaboratorio+" id laboratorio servicios");
			equipoDAO.asociarEquipo(idlaboratorio, idequipo);
		} catch (PersistenceException e)
		{
			throw new PersistenceException(e + " Error, no se pudo asociar el equipo");
		}
	}
	
	@Override
	public void bajarEquipo(int id)
	{
		equipoDAO.bajarEquipo(id);
	}
	
	@Override
	public void eliminiarAsociacionLaboratorio(int idequipo)
	{
		equipoDAO.eliminarAsociacion(idequipo);
	}
}
