package edu.eci.cvds.persistencia;

import java.util.Date;
import java.util.List;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;

public interface NovedadDAO 
{
	public Novedad getNovedad(int id)throws PersistenceException;
	
	public List<Novedad> getNovedadPorEquipo(int idequipo)throws PersistenceException;
	
	public List<Novedad> getNovedadPorElemento(int idelemento)throws PersistenceException;
	
	public List<Novedad> getNovedades() throws PersistenceException;
	
	public void agregarNovedad(Date fecha, int carnet, int idlaboratorio, int idequipo, int idelemento, String descripcion, TipoNovedad tiponovedad) throws PersistenceException;
}