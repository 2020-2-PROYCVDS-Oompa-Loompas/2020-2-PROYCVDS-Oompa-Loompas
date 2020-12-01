package edu.eci.cvds.servicios.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.persistencia.LaboratorioDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.ServiciosLab;
import java.util.Date;
import java.util.List;

@Singleton
public  class ServiciosECILabImpl implements ServiciosLab
{
	@Inject
	private LaboratorioDAO laboratorioDAO;

	@Override
	public void agregarLaboratorio(String nombre, int capacidad) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			laboratorioDAO.agregarLaboratorio(nombre, capacidad);
		} catch(PersistenceException e)
		{
			throw new ExcepcionServiciosLab("Error al agregar el laboratorio");
		}
	}

	@Override
	public List<Laboratorio> getLaboratorios() throws ExcepcionServiciosLab 
	{
		return laboratorioDAO.getLaboratorios();
	}

	@Override
	public List<Laboratorio> getLaboratoriosDisponibles() throws ExcepcionServiciosLab 
	{
		return laboratorioDAO.getLaboratoriosDisponibles();
	}

	@Override
	public void asociarEquipo(String nombre) throws ExcepcionServiciosLab, PersistenceException
	{
		laboratorioDAO.asociarEquipo(nombre);
	}
	
	@Override
	public void cerrarLaboratorio(String nombre)
	{
		laboratorioDAO.cerrarLaboratorio(nombre);
	}

	@Override
	public Laboratorio getLaboratorioPorNombre(String nombre) throws ExcepcionServiciosLab 
	{
		return laboratorioDAO.getLaboratorioPorNombre(nombre);
	}
}
