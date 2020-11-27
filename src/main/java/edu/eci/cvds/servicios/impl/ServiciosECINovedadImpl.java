package edu.eci.cvds.servicios.impl;

import java.util.Date;
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
	public void agregarNovedadAsociacion(String carnet, int idequipo, String descripcion, TipoNovedad tipoNovedad) throws PersistenceException
	{
		novedadDAO.agregarNovedadAsociacion(carnet, idequipo, descripcion, tipoNovedad);
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

	@Override
	public void agregarNovedad(Date fecha, String carnet, int idlaboratorio, int idequipo, int idelemento,
			String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException {
		novedadDAO.agregarNovedad(fecha, carnet, idequipo, idelemento, descripcion, tiponovedad);
		
	}
	
	public void agregarNovedadAlRegistroLab(String carnet, int idequipo, String descripcion,
			TipoNovedad registrar)
	{
		novedadDAO.agregarNovedadAlRegistroLab(carnet, idequipo, descripcion, registrar);
	}
}
