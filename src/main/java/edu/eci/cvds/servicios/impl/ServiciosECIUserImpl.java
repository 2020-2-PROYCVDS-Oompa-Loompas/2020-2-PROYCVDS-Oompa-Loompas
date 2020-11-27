package edu.eci.cvds.servicios.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.ServiciosUsuario;

public class ServiciosECIUserImpl implements ServiciosUsuario
{
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosLab, PersistenceException{
		   return usuarioDAO.obtenerUsuarios();
	   }

	@Override
	public void agregarUsuario(String carnet, String nombre, String correo, String contrasena, String estado, String rol) throws ExcepcionServiciosLab, PersistenceException {
				
		try
		{
			usuarioDAO.agregarUsuario(carnet, nombre, correo, contrasena, estado, rol);
		} catch(PersistenceException e)
		{
			throw new ExcepcionServiciosLab("Error al agregar el usuario");
		}
		
	}
}
