package edu.eci.cvds.persistencia;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.entities.Novedad;

public interface NovedadDAO 
{
	public Novedad getNovedad(int id)throws PersistenceException;
	
	public List<Novedad> getNovedades() throws PersistenceException;
}