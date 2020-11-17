package edu.eci.cvds.security;

import edu.eci.cvds.servicios.ExcepcionServiciosLab;



public interface Sesion {
    public void login(String correo,String password) throws ExcepcionServiciosLab;
    public boolean estaLogeado();
}