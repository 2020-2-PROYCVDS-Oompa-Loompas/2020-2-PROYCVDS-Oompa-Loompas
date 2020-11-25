package edu.eci.cvds.servicios;

import java.util.List;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosUsuario 
{
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosLab, PersistenceException;
}
