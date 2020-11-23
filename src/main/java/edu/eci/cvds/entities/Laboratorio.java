package edu.eci.cvds.entities;

import java.time.LocalDate;

public class Laboratorio {
	
	private int id;
	private String nombre;
	private int capacidad;
	private boolean disponible;
	private LocalDate fechacierre;
	private LocalDate fechacreacion;
	
	public Laboratorio() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public boolean getDisponible()
	{
		return disponible;
	}
	
	public LocalDate getFechaCreacion() {
		return fechacreacion;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFechaCreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * @return the fecha
	 */
	public LocalDate getFechaCierre() {
		return fechacierre;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFechaCierre(LocalDate fechacierre) {
		this.fechacierre = fechacierre;
	}
	
	@Override
    public String toString() 
	{
        return "Laboratorio {id: " + id + ", nombre: " + nombre + " , capacidad: " + capacidad + ", disponible: " + disponible +", fechacreacion: " + fechacreacion + ", fechacierre: " + fechacierre + "}\n";
    }

}
