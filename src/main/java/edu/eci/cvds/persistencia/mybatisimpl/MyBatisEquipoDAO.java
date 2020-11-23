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
	public void agregarEquipo(String nombre, boolean disponible, boolean funcionamiento, int idlaboratorio) throws PersistenceException
	{
		mapper.agregarEquipo(nombre, disponible, funcionamiento, idlaboratorio);
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
			throw new PersistenceException("No puedes asociar equipos no disponibles");
		}
		else if(!getEquipo(id).getFuncionamiento())
		{
			throw new PersistenceException("No puedes asociar elementos a equipos fuera de funcionamiento");
		}
		else
		{
			mapper.asociarEquipo(id);
		}
	}
	
	@Override
	public void bajarEquipo(int id)
	{
		mapper.bajarEquipo(id);
	}
}
