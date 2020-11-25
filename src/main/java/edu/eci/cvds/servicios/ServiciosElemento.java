package edu.eci.cvds.servicios;

import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistencia.PersistenceException;

public interface ServiciosElemento 
{
	public Elemento getElemento(int id) throws ExcepcionServiciosLab;
	   
	public void agregarElemento(String nombre, String fabricante, boolean disponible, int idequipo) throws ExcepcionServiciosLab, PersistenceException;
	   
	public List<Elemento> getElementos() throws ExcepcionServiciosLab;
		
	public List<Elemento> getElementoOrdenadoPorId() throws ExcepcionServiciosLab;
		
	public List<Elemento> getElementoOrdenadoPorCategoria() throws ExcepcionServiciosLab;
		
	public List<Elemento> getElementoOrdenadoPorFabricante() throws ExcepcionServiciosLab;
		
	public List<Elemento> getElementoOrdenadoPorDisponible() throws ExcepcionServiciosLab;
		
	public List<Elemento> getElementoOrdenadoPorIdEquipo() throws ExcepcionServiciosLab;
	   
	public List<Elemento> getElementosDisponibles() throws ExcepcionServiciosLab;
		
	public List<Elemento> getElementosPorCategoria(String categoria) throws ExcepcionServiciosLab;
	   
	public List<Elemento> getElementosPorFabricante(String fabricante) throws ExcepcionServiciosLab;
		
	public void asociarElemento(int id) throws ExcepcionServiciosLab;

	public void bajarElemento(int id) throws ExcepcionServiciosLab, PersistenceException;
}
