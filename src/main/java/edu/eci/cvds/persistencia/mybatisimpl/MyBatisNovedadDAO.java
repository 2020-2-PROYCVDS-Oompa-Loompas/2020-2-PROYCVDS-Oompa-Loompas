package edu.eci.cvds.persistencia.mybatisimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.google.inject.Inject;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.NovedadDAO;
import edu.eci.cvds.entities.Novedad;
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
}
