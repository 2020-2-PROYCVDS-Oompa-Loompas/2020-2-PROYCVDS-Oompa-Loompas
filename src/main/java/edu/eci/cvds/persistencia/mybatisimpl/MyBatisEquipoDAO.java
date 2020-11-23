package edu.eci.cvds.persistencia.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistencia.EquipoDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.EquipoMapper;

public class MyBatisEquipoDAO implements EquipoDAO
{
	@Inject
	private EquipoMapper mapper;
	
	@Override
	public Equipo getEquipo(int id)
	{
		return mapper.getEquipo(id);
	}
	
	@Override
	public void agregarEquipo(String nombre, boolean disponible, int idlaboratorio) throws PersistenceException
	{
		mapper.agregarEquipo(nombre, disponible, idlaboratorio);
	}
	
	@Override
	public List<Equipo> getEquiposDisponibles()
	{
		return mapper.getEquiposDisponibles();
	}
	
	@Override
	public void asociarEquipo(int id) throws PersistenceException
	{
		if(!getEquipo(id).getDisponible())
		{
			throw new PersistenceException("No puedes asocair equipos no disponibles");
		}
		else
		{
			mapper.asociarEquipo(id);
		}
	}
}
