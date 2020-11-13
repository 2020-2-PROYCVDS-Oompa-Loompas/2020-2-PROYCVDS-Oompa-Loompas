package edu.eci.cvds.entities;

import java.io.Serializable;

public class Usuario implements Serializable
{
	private int carnet;
	private String nombre;
	private String correo;
	private String contrasena;
	private String estado;
	private String rol;
	
	
	/**
	* Constructor del usuario en el sistema
	*/
	public Usuario(){}


	/**
	 * @return the carnet
	 */
	public int getCarnet() {
		return carnet;
	}


	/**
	 * @param carnet the carnet to set
	 */
	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}


	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}


	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}


	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
    public String toString() {
        return "Usuario {carnet: " + carnet + ", nombre: " + nombre + " ,correo: " + correo + ", contraseña: " + contrasena + ", estado : " + estado + ", rol: " + rol  + "}\n";
    }
	
	
}