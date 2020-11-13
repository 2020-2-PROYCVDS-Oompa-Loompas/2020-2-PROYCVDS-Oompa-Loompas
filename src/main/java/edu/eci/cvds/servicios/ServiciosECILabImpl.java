package edu.eci.cvds.servicios;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.UsuarioDAO;
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
	
}
