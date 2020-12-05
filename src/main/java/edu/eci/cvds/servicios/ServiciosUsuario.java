package edu.eci.cvds.servicios;

import java.util.List;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosUsuario 
{
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosLab, PersistenceException;

	public void agregarUsuario(String carnet, String nombre, String correo, String contrasena, String estado, Rol rol) throws ExcepcionServiciosLab;
}
