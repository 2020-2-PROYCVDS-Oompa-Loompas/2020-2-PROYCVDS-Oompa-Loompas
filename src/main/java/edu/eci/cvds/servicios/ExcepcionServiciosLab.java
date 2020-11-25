package edu.eci.cvds.servicios;

public class ExcepcionServiciosLab extends Exception {
	public static final String USUARIO_INCORRECTO = "El numero de documento ingresado es incorecto";
    
    public static final String CONTRASENA_INCORRECTA = "La contraseña ingresada es incorrecta";
	public ExcepcionServiciosLab() {
    }
		
	public ExcepcionServiciosLab(String message) {
		super(message);
	}
		
	public ExcepcionServiciosLab(String message, Exception e) {
		super(message);
		e.printStackTrace();
	}
	
	public ExcepcionServiciosLab(Throwable cause) {
        super(cause);
    }
}