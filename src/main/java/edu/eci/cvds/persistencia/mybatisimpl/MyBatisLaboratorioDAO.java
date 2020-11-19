package edu.eci.cvds.persistencia.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistencia.LaboratorioDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.LaboratorioMapper;

public class MyBatisLaboratorioDAO implements LaboratorioDAO
{
	@Inject
	private LaboratorioMapper mapper;
	
	@Override
	public Laboratorio getLaboratorio(int id)
	{
		return mapper.getLaboratorio(id);
	}
	
	@Override
	public List<Laboratorio> getLaboratorios()
	{
		return mapper.getLaboratorios();
	}
	
	@Override
	public List<Laboratorio> getLaboratoriosDisponibles()
	{
		return mapper.getLaboratoriosDisponibles();
	}
	
	@Override
	public List<Equipo> getEquiposLaboratorio(int id)
	{
		return mapper.getEquiposLaboratorio(id);
	}
	
	@Override
	public void agregarLaboratorio(String nombre, int capacidad, boolean disponible) throws PersistenceException
	{
		if(nombre == null || nombre == "")
		{
			throw new PersistenceException ("El nombre del laboratorio no debe estar vacio");
		}
		else
		{
			mapper.agregarLaboratorio(nombre, capacidad, disponible);
		}
	}
}
