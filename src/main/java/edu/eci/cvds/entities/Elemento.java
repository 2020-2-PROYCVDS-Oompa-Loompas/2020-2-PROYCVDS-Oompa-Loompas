package edu.eci.cvds.entities;

public class Elemento {
	
	private int id;
	private String fabricante;
	private String categoria;
	private int Capacidad;
	private int idequipo;
	private boolean disponible;
	
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
		return idequipo;
	}

	/**
	 * @param idEquipo the idEquipo to set
	 */
	public void setIdEquipo(int idEquipo) {
		this.idequipo = idEquipo;
	}
	
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}
	
	public String getCategoria()
	{
		return categoria;
	}
	
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public boolean getDisponible()
	{
		return disponible;
	}
	
	@Override
    public String toString() 
	{
        return "Elemento {id: " + id + ", categoria: " + categoria + " , fabricante: " + fabricante + ", disponible: " + disponible + ", idequipo: " + idequipo + "}\n";
    }

}
