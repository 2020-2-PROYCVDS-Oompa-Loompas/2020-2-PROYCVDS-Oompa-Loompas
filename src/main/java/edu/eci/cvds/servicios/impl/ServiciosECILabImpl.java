package edu.eci.cvds.servicios.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.persistencia.LaboratorioDAO;
import edu.eci.cvds.persistencia.NovedadDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.ServiciosLab;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import org.mybatis.guice.transactional.Transactional;

@Singleton
public  class ServiciosECILabImpl implements ServiciosLab
{
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private NovedadDAO novedadDAO;
	@Inject
	private LaboratorioDAO laboratorioDAO;
	
	@Override
	   public Usuario consultarUsuarioLog(int carnet, String contrasena) throws PersistenceException{
		   try {
	            return usuarioDAO.obtenerUsuarioLog(carnet,contrasena);
	        } catch (PersistenceException e) {
	            throw new PersistenceException("Error al consultar el item " + carnet, e);
	        }
	   }
	   
	@Override
	   public List<Usuario> consultarUsuarios() throws PersistenceException{
		   try {
	            return usuarioDAO.obtenerUsuarios();
	        } catch (PersistenceException e) {
	            throw new PersistenceException("Error al consultar el item ", e);
	        }
	   }
	
	@Override
	   public Novedad getNovedad(int id){
		   /*try {
	            return novedadoDAO.obtenerUsuarios();
	        } catch (PersistenceException e) {
	            throw new PersistenceException("Error al consultar el item ", e);
	        }*/
			return null;
	   }

	@Override
	public List<Novedad> getNovedades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarNovedad(LocalDate fecha, int carnet, int idlaboratorio, int idequipo, String descripcion,
			TipoNovedad tiponovedad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Laboratorio getLaboratorio(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarLaboratorio(String nombre, int capacidad, boolean disponible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Laboratorio> getLaboratorios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laboratorio> getLaboratoriosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> getEquiposLaboratorio(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo getEquipo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarEquipo(String nombre, boolean disponible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Elemento getElemento(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarElemento(String nombre, String fabricante, boolean disponible) {
		// TODO Auto-generated method stub
		
	}
	
}
