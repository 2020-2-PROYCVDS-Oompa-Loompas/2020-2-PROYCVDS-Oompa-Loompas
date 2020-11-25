package edu.eci.cvds.servicios.impl;

import java.time.LocalDate;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.persistencia.NovedadDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.ServiciosNovedad;

public class ServiciosECINovedadImpl implements ServiciosNovedad
{
	@Inject
	private NovedadDAO novedadDAO;
	
	@Override
	public Novedad getNovedad(int id) throws ExcepcionServiciosLab, PersistenceException
	{
		return novedadDAO.getNovedad(id);
	}

	@Override
	public List<Novedad> getNovedades() throws ExcepcionServiciosLab, PersistenceException 
	{
		return novedadDAO.getNovedades();
	}

	@Override
	public void agregarNovedad(LocalDate fecha, int carnet, int idlaboratorio, int idequipo, int idelemento, String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException 
	{
		novedadDAO.agregarNovedad(fecha, carnet, idlaboratorio, idequipo, idelemento, descripcion, tiponovedad);
	}

	@Override
	public List<Novedad> getNovedadPorEquipo(int idequipo)throws ExcepcionServiciosLab, PersistenceException
	{
		return novedadDAO.getNovedadPorEquipo(idequipo);
	}
	
	@Override
	public List<Novedad> getNovedadPorElemento(int idelemento)throws ExcepcionServiciosLab, PersistenceException
	{
		return novedadDAO.getNovedadPorElemento(idelemento);
	}
}
