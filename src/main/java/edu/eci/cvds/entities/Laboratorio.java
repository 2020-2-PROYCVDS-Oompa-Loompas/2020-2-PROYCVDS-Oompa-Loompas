package edu.eci.cvds.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Laboratorio {
	
	private int id;
	private String nombre;
	private int capacidad;
	private boolean disponible;
	private Date fechacierre;
	private Date fechacreacion;
	
	public Laboratorio() {}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
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
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public Date getFechaCreacion() {
		return fechacreacion;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * @return the fecha
	 */
	public Date getFechaCierre() {
		return fechacierre;
	}
	
	public String getFechaCreacionString() {
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        return dt1.format(this.fechacreacion);
	}
	
	public String getFechaCierreString() {
		String fechaNoDefinida = "Fecha no definida";
		if(fechacierre != null)
		{
			SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
			return dt1.format(this.fechacierre);
		}
		else
		{
			return fechaNoDefinida;
		}
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFechaCierre(Date fechacierre) {
		this.fechacierre = fechacierre;
	}
	
	@Override
    public String toString() 
	{
        return "Laboratorio { nombre: " + nombre + " , capacidad: " + capacidad + ", fechacreacion: " + fechacreacion + ", fechacierre: " + fechacierre + "}\n";
    }
}
