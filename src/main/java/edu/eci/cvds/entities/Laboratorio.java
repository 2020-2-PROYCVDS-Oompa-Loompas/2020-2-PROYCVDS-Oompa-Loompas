package edu.eci.cvds.entities;

import java.time.LocalDate;

public class Laboratorio {
	
	private String nombre;
	private int capacidad;
	private LocalDate fechacierre;
	private LocalDate fechacreacion;
	
	public Laboratorio() {}

	

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
        return "Laboratorio { nombre: " + nombre + " , capacidad: " + capacidad + ", fechacreacion: " + fechacreacion + ", fechacierre: " + fechacierre + "}\n";
    }
}
