package edu.eci.cvds.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.excepciones.ECILabExcepcion;
//import com.registerLab.entities.Elemento;
//import com.registerLab.entities.Equipo;
//import com.registerLab.entities.Laboratorio;
//import com.registerLab.entities.Novedad;
import edu.eci.cvds.entities.Usuario;

public interface ServiciosECILab 
{	
	public Usuario getUsuario(String correo);
	public void registrarUsuario(int carnet, String nombre, String correo, String contrasena, String estado, String rol);
}
