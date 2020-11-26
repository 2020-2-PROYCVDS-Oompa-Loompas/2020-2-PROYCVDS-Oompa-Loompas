package edu.eci.cvds.entities;

public class Equipo {
	
	private int id;
	private String nombre;
	private boolean disponible;
	private boolean funcionamiento;
	private String laboratorio;
	
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

	public void setFuncionamiento(boolean funcionamiento)
	{
		this.funcionamiento = funcionamiento;
	}
	
	public boolean getFuncionamiento()
	{
		return funcionamiento;
	}
	
	public void setLaboratorio(String id)
	{
		laboratorio = id;
	}
	
	public String getLaboratorio()
	{
		return laboratorio;
	}
	
	@Override
    public String toString() {
        return "Equipo {id: " + id + ", nombre: " + nombre + " , disponible: " + disponible +", funcionamiento: " + funcionamiento + ", laboratorio: " + laboratorio + "}\n";
    }
}
