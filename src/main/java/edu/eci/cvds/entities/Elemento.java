package edu.eci.cvds.entities;

public class Elemento {
	
	private int id;
	private String fabricante;
	private String categoria;
	private int Capacidad;
	private String equipo;
	private boolean disponible;
	private boolean funcionamiento;
	
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
	public String getEquipo() {
		return equipo;
	}

	/**
	 * @param idEquipo the idEquipo to set
	 */
	public void setEquipo(String Equipo) {
		this.equipo = Equipo;
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
	
	public void setFuncionamiento(boolean funcionamiento)
	{
		this.funcionamiento = funcionamiento;
	}
	
	public boolean getFuncionamiento()
	{
		return funcionamiento;
	}
	
	@Override
    public String toString() 
	{
        return "Elemento {id: " + id + ", categoria: " + categoria + " , fabricante: " + fabricante + ", disponible: " + disponible + ", funcionamiento: " + funcionamiento + ", equipo: " + equipo + "}\n";
    }

}
