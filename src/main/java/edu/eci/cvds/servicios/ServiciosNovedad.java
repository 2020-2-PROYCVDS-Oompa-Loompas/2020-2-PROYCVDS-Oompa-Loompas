package edu.eci.cvds.servicios;

import java.time.LocalDate;
import java.util.List;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosNovedad 
{
	public Novedad getNovedad(int id) throws ExcepcionServiciosLab, PersistenceException;	
	   
	public List<Novedad> getNovedades() throws ExcepcionServiciosLab, PersistenceException;
	   
	public void agregarNovedad(LocalDate fecha, int carnet, int idlaboratorio, int idequipo, int idelemento, String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException;
	   
	public List<Novedad> getNovedadPorEquipo(int idequipo)throws ExcepcionServiciosLab, PersistenceException;
		
	public List<Novedad> getNovedadPorElemento(int idelemento)throws ExcepcionServiciosLab, PersistenceException;
}
