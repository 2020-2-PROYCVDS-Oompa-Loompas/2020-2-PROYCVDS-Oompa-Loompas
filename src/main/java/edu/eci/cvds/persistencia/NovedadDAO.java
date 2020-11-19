package edu.eci.cvds.persistencia;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;

public interface NovedadDAO 
{
	public Novedad getNovedad(int id)throws PersistenceException;
	
	public List<Novedad> getNovedades() throws PersistenceException;
	
	public void agregarNovedad(LocalDate fecha, int carnet, int idlaboratorio, int idequipo, String descripcion, TipoNovedad tiponovedad) throws PersistenceException;
}