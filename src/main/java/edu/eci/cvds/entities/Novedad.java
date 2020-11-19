package edu.eci.cvds.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Novedad implements Serializable
{	
	private int id;
	private LocalDate fecha;
	private int carnet;
	private int idlaboratorio;
	private int idequipo;
	private String descripcion;
	private String tiponovedad;
	
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
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
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
		return idlaboratorio;
	}

	/**
	 * @param idLaboratorio the idLaboratorio to set
	 */
	public void setIdLaboratorio(int idLaboratorio) {
		this.idlaboratorio = idLaboratorio;
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
		return tiponovedad;
	}

	/**
	 * @param tipoNovedad the tipoNovedad to set
	 */
	public void setTipoNovedad(String tipoNovedad) {
		this.tiponovedad = tipoNovedad;
	}
	
	public String getFechaString() {
		SimpleDateFormat dt1 = new SimpleDateFormat("YYYY-MM-DD");
        return dt1.format(this.fecha);
	}
	
	@Override
    public String toString() {
        return "Novedad {id: " + id + ", fecha: " + fecha + " ,carnet: " + carnet + ", idlaboratorio: " + idlaboratorio + ", idequipo : " + idequipo + ", descripcion: " + descripcion  + ", tipo novedad: " + tiponovedad + "}\n";
    }
}
