package edu.eci.cvds.servicios;

import java.util.Date;
import java.util.List;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosNovedad 
{
	public Novedad getNovedad(int id) throws ExcepcionServiciosLab, PersistenceException;	
	   
	public List<Novedad> getNovedades() throws ExcepcionServiciosLab, PersistenceException;
	   
	public void agregarNovedad(Date fecha, String carnet, int idlaboratorio, int idequipo, int idelemento, String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException;
	
	public void agregarNovedadAsociacion(String carnet, int idequipo, String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException;
	
	public void agregarNovedadAlRegistroLab(String carnet, int idequipo, String descripcion,
			TipoNovedad registrar);
			
	public void agregarNovedadDeEquipo(String carnet, String descripcion, TipoNovedad registrar);
	
	public void agregarNovedadElemento(String carnet, String descripcion, TipoNovedad registrar);
	   
	public List<Novedad> getNovedadPorEquipo(int idequipo)throws ExcepcionServiciosLab, PersistenceException;
		
	public List<Novedad> getNovedadPorElemento(int idelemento)throws ExcepcionServiciosLab, PersistenceException;

	public void agregarNovedadAlAsociarElemento(String carnet, int idEquipo, int idElemento, String descripcion,
			TipoNovedad registrar);
	
	public void agregarNovedadEliminarAscElemento(String carnet, int idElemento, String descripcion,
	TipoNovedad registrar);

	public void agregarNovedadBajarEquipo(String carnet, int id, String descripcion, TipoNovedad darDeBaja);
}
