package edu.eci.cvds.entities;

public class Equipo {
	
	private int id;
	private String nombre;
	private boolean disponible;
	private int idlaboratorio;
	
	public Equipo() {}

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
	
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public boolean getDisponible()
	{
		return disponible;
	}
	
	public void setIdLaboratorio(int id)
	{
		idlaboratorio = id;
	}
	
	public int getIdLaboratorio()
	{
		return idlaboratorio;
	}
	
	@Override
    public String toString() {
        return "Equipo {id: " + id + ", nombre: " + nombre + " , disponible: " + disponible +", idlaboratorio: " + idlaboratorio + "}\n";
    }
}
