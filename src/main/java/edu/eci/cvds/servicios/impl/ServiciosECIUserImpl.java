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
}
