package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import java.math.BigInteger;
import java.util.List;

public class MyBatisUsuarioDAO implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;

  
	
	@Override
    public List<Usuario> obtenerUsuarios() throws PersistenceException {
        try{
             return usuarioMapper.consultarUsuarios();
         }
         catch(Exception e){
             System.out.println(e);
             throw new PersistenceException("Error al consultar los usuarios:",e);
         }	
        
   
    }



	@Override
	public void agregarUsuario(String carnet, String nombre, String correo, String contrasena, String estado, Rol rol) {
		usuarioMapper.agregarUsuario(carnet, nombre, correo, contrasena, estado, rol);
		
	}		
	
	
}
