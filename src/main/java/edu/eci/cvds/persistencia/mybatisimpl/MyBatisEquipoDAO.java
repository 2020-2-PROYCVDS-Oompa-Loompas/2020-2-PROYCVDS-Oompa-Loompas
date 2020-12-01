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
	public List<Equipo> getEquipos()
	{
		return mapper.getEquipos();
	}
	
	@Override
	public List<Equipo> getEquiposLaboratorio(String laboratorio)
	{
		return mapper.getEquiposLaboratorio(laboratorio);
	}
	
	@Override
	public void agregarEquipo(String nombre) throws PersistenceException
	{
		mapper.agregarEquipo(nombre);
	}
	
	@Override
	public List<Equipo> getEquiposDisponibles()
	{
		return mapper.getEquiposDisponibles();
	}
	
	@Override
	public void asociarEquipo(int idlaboratorio, int idequipo) throws PersistenceException
	{
		if(!getEquipo(idequipo).getDisponible())
		{
			throw new PersistenceException("No puedes asociar equipos no disponibles");
		}
		else if(!getEquipo(idequipo).getFuncionamiento())
		{
			throw new PersistenceException("No puedes asociar elementos a equipos fuera de funcionamiento");
		}
		else
		{
			System.out.println(idlaboratorio+" id laboratorio mybtis");
			mapper.asociarEquipo(idlaboratorio, idequipo);
		}
	}
	
	@Override
	public void bajarEquipo(int id)
	{
		mapper.bajarEquipo(id);
	}
	
	public void eliminarAsociacion(int idequipo)
	{
		mapper.eliminarAsociacion(idequipo);
	}
}
