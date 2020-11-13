package edu.eci.cvds.entities;


import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Novedad {
	
	private int id;
	private Date fecha;
	private int carnet;
	private int idLaboratorio;
	private int idEquipo;
	private String descripcion;
	private String tipoNovedad;
	
	public Novedad() {}

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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

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
	 * @return the idLaboratorio
	 */
	public int getIdLaboratorio() {
		return idLaboratorio;
	}

	/**
	 * @param idLaboratorio the idLaboratorio to set
	 */
	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipoNovedad
	 */
	public String getTipoNovedad() {
		return tipoNovedad;
	}

	/**
	 * @param tipoNovedad the tipoNovedad to set
	 */
	public void setTipoNovedad(String tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}
	
	public String getFechaString() {
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        return dt1.format(this.fecha);
	}

}
