package edu.eci.cvds.servicios;

public class ExcepcionServiciosLab extends Exception {
		
	public ExcepcionServiciosLab(String message) {
		super(message);
	}
		
	public ExcepcionServiciosLab(String message, Exception e) {
		super(message);
		e.printStackTrace();
	}
}