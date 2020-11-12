package edu.eci.cvds.DAO;

import edu.eci.cvds.entities.Usuario;

public interface UsuarioDAO
{
	public Usuario getUsuario(String correo);
	public void registrarUsuario(int carnet, String nombre, String correo, String contrasena, String estado, String rol);
}