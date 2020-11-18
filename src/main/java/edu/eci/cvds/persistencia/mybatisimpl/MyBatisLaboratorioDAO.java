package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

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
	public void agregarLaboratorio(int id, String nombre, int capacidad) throws PersistenceException
	{
		if(getLaboratorio(id) != null)
		{
			throw new PersistenceException ("Este laboratorio ya esta registrado");
		}
		else if(nombre == null || nombre == "")
		{
			throw new PersistenceException ("El nombre del laboratorio no debe estar vacio");
		}
		else
		{
			mapper.agregarLaboratorio(id, nombre, capacidad);
		}
	}
}
