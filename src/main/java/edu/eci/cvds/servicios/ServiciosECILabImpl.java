package edu.eci.cvds.servicios;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;
import edu.eci.cvds.excepciones.ECILabExcepcion;
//import com.registerLab.DAO.ElementoDAO;
//import com.registerLab.DAO.EquipoDAO;
//import com.registerLab.DAO.LaboratorioDAO;
//import com.registerLab.DAO.NovedadDAO;
import edu.eci.cvds.DAO.UsuarioDAO;
//import com.registerLab.entities.Elemento;
//import com.registerLab.entities.Equipo;
//import com.registerLab.entities.Laboratorio;
//import com.registerLab.entities.Novedad;
import edu.eci.cvds.entities.Usuario;

public  class ServiciosECILabImpl implements ServiciosECILab
{
	@Inject
	private UsuarioDAO usuario;
	//@Inject
	//private EquipoDAO equipo;
	//@Inject
	//private LaboratorioDAO laboratorio;
	//@Inject
	//private NovedadDAO novedad;
	//@Inject
	//private ElementoDAO elemento;
	//@Inject
	//private MyBatisUsuarioDAO usuario;
	
	
	/*
	 * @param correo - correo del usuario a buscar
	 * @return devuelve el Usuario correspondiente al correo
	 */
	public Usuario getUsuario(String correo) 
	{
		return usuario.getUsuario(correo);
	}
	
	@Override
	public void registrarUsuario(int carnet, String nombre, String correo, String contrasena, String estado, String rol)
	{
		usuario.registrarUsuario(carnet, nombre, correo, contrasena, estado, rol);
	}
	
}
