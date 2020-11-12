package edu.eci.cvds.entities;

import java.io.Serializable;

public class Usuario implements Serializable
{
	private int carnet;
	private String nombre;
	private String apellido;
	private String correo;
	private String rol;
	private String contrasena;
	
	/**
	* Constructor del usuario en el sistema
	*/
	public Usuario(){}
	
	/**
	* Establecemos el carnet asignado al usuario
	* @param carnet
	*/
	public void setCarnet(int carnet) 
	{
		this.carnet=carnet;
	}
	
	/**
	* Establecemos el nombre del usuario ingresado al sistema
	* @param nombre
	*/
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	* Establecemos el apellido del usuario ingresado al sistema
	* @param apellido
	*/
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
	
	/**
	* Establecemos el correo del usuario ingresado al sistema
	* @param correo
	*/
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	
	/**
	* Establecemos el rol del usuario ingresado al sistema
	* @param rol
	*/
	public void setRol(String rol)
	{
		this.rol = rol;
	}
	
	/**
	* Establecemos el contraseña del usuario ingresado al sistema
	* @param contrasena
	*/
	public void setContra(String contrasena)
	{
		this.contrasena = contrasena;
	}
	
	/**
	* Obtener el carnet del usuario ingresado al sistema
	* @return id
	*/
	public int getCarnet()
	{
		return carnet;
	}
	
	/**
	* Obtener el nombre del usuario ingresado al sistema
	* @return nombre
	*/
	public String getNombre()
	{
		return nombre;
	}
	
	/**
	* Obtener el apellido del usuario ingresado al sistema
	* @return apellido
	*/
	public String getApellido() 
	{
		return apellido;
	}
	
	/**
	* Obtener el rol del usuario ingresado al sistema
	* @return rol
	*/
	public String getRol() 
	{
		return rol;
	}
	
	/**
	* Obtener la contraseña del usuario ingresado al sistema
	* @return contrasena
	*/
	public String getContrasena()
	{
		return contrasena;
	}
	
	/**
	* Obtener el correo del usuario ingresado al sistema
	* @return correo
	*/
	public String getCorreo()
	{
		return correo;
	}
}