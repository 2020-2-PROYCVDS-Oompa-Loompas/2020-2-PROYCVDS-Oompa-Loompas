package edu.eci.cvds.myBatisDAO.mapper;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;

public interface UsuarioMapper 
{
	public Usuario getUsuario(@Param("Correo") String correo);
	public void registrarUsuario(@Param("carnet")int carnet, @Param("nombre")String nombre, @Param("correo")String correo, @Param("contrasena")String contrasena, @Param("estado")String estado, @Param("rol")String rol);
}