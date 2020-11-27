package edu.eci.cvds.servicios;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosUsuario 
{
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosLab, PersistenceException;
	
	public void agregarUsuario(String carnet, String nombre, String correo, String contrasena, String estado, String rol) throws ExcepcionServiciosLab,PersistenceException;
}
