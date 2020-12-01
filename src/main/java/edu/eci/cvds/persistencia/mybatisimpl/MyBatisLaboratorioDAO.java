package edu.eci.cvds.persistencia.mybatisimpl;

import java.util.Date;
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
	public Laboratorio getLaboratorioPorNombre(String nombre)
	{
		return mapper.getLaboratorioPorNombre(nombre);
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
	public void agregarLaboratorio(String nombre, int capacidad) throws PersistenceException
	{
		if(nombre == null || nombre == "")
		{
			throw new PersistenceException ("El nombre del laboratorio no debe estar vacio");
		}
		else
		{
			mapper.agregarLaboratorio(nombre, capacidad, (Date) null, (Date) null);
		}
	}
	
	@Override
	public void asociarEquipo(String nombre) throws PersistenceException
	{
		Laboratorio e = getLaboratorioPorNombre(nombre);
		
		if(e == null)
		{
			throw new PersistenceException ("El equipo no se encuentra registrado");
		}
		else
		{
			mapper.asociarEquipo(nombre);
		}
	}
	
	@Override
	public void cerrarLaboratorio(String nombre)
	{
		mapper.cerrarLaboratorio(nombre);
	}
}
