package edu.eci.cvds.security;

public class ExceptionLogin extends Exception{

    private static final long serialVersionUID = 5758585917279118959L;

    public ExceptionLogin(String message, Exception e) {
        super(message,e);
    }

    public ExceptionLogin(String message){
        super(message);
    }
    
}
