package edu.eci.cvds.entities;

public class Elemento {
	
	private int id;
	private String fabricante;
	private int Capacidad;
	private int idEquipo;
	
	public Elemento() {	}

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
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return Capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}

	/**
	 * @return the idEquipo
	 */
	public int getIdEquipo() {
		return idEquipo;
	}

	/**
	 * @param idEquipo the idEquipo to set
	 */
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	
}
