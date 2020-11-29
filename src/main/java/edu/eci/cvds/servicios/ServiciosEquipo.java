package edu.eci.cvds.servicios;

import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosEquipo 
{
	public Equipo getEquipo(int id) throws ExcepcionServiciosLab;
	
	public List<Equipo> getEquipos() throws ExcepcionServiciosLab;
	   
	public void agregarEquipo(String nombre) throws ExcepcionServiciosLab, PersistenceException;
	   
	public List<Equipo> getEquiposDisponibles() throws ExcepcionServiciosLab;
		
	public void asociarEquipoAlLab(int idlaboratorio, int idequipo) throws ExcepcionServiciosLab, PersistenceException;
		
	public void bajarEquipo(int id) throws ExcepcionServiciosLab;

	public void eliminiarAsociacionLaboratorio(int idequipo);
}
