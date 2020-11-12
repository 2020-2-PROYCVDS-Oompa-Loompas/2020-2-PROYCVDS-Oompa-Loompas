package edu.eci.cvds.myBatisDAO;

import com.google.inject.Inject;
import edu.eci.cvds.DAO.UsuarioDAO;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.myBatisDAO.mapper.UsuarioMapper;

public class MyBatisUsuarioDAO implements UsuarioDAO
{
	@Inject
	private UsuarioMapper mapper;
	
	@Override
	public Usuario getUsuario(String correo)
	{
		return mapper.getUsuario(correo);
	}
	
	@Override
	public void registrarUsuario(int carnet, String nombre, String correo, String contrasena, String estado, String rol)
	{
		mapper.registrarUsuario(carnet, nombre, correo, contrasena, estado, rol);
	}
}