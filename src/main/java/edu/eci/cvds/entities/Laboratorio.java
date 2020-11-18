package edu.eci.cvds.entities;

public class Laboratorio {
	
	private int id;
	private String nombre;
	private int capacidad;
	
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
	
	@Override
    public String toString() 
	{
        return "Laboratorio {id: " + id + ", nombre: " + nombre + " , capacidad: " + capacidad + "}\n";
    }

}
