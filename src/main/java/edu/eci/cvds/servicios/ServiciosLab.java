package edu.eci.cvds.servicios;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;

import java.sql.Date;
import java.util.List;

public interface ServiciosLab {

   public abstract Usuario consultarUsuarioLog(int carnet, String contrasena) throws PersistenceException;

   public abstract List<Usuario> consultarUsuarios() throws PersistenceException;

   
}