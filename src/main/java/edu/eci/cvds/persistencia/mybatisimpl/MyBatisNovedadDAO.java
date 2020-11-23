package edu.eci.cvds.persistencia.mybatisimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.NovedadDAO;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.NovedadMapper;

public class MyBatisNovedadDAO implements NovedadDAO
{	
	@Inject
	private NovedadMapper mapper;
	
	@Override
	public Novedad getNovedad(int id) throws PersistenceException 
	{
		try{
			return mapper.getNovedad(id);
			}
		catch(Exception e)
		{
			System.out.println(e);
			throw new PersistenceException("Error al consultar la novedad:",e);
			}
	}
	
	@Override
	public List<Novedad> getNovedadPorEquipo(int idequipo) throws PersistenceException 
	{
		try{
			return mapper.getNovedadPorEquipo(idequipo);
			}
		catch(Exception e)
		{
			System.out.println(e);
			throw new PersistenceException("Error al consultar la novedad:",e);
			}
	}
	
	@Override
	public List<Novedad> getNovedadPorElemento(int idelemento) throws PersistenceException 
	{
		try{
			return mapper.getNovedadPorElemento(idelemento);
			}
		catch(Exception e)
		{
			System.out.println(e);
			throw new PersistenceException("Error al consultar la novedad:",e);
			}
	}
	
	@Override
	public List<Novedad> getNovedades() throws PersistenceException
	{
		try {
			return mapper.getNovedades();
		} catch(Exception e)
		{
			System.out.println(e);
			throw new PersistenceException("Error al consultar las novedades:",e);
		}
	}
	
	public void agregarNovedad(@Param("fecha") LocalDate fecha, @Param("carnet") int carnet, @Param("idlaboratorio") int idlaboratorio, @Param("idequipo") int idequipo, @Param("idelemento") int idelemento, @Param("descripcion") String descripcion, @Param("tiponovedad") TipoNovedad tiponovedad) throws PersistenceException
	{
		if(descripcion == "")
		{
			throw new PersistenceException("No se puede agregar la novedad sin justificación");
		}
		else
		{
			mapper.agregarNovedad(fecha, carnet, idlaboratorio, idequipo, idelemento, descripcion, tiponovedad);
		}
	}
}
