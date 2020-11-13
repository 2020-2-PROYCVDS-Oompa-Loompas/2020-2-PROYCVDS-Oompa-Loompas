package edu.eci.cvds;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

 

import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.servicios.ServiciosECILabImpl;
import edu.eci.cvds.servicios.ServiciosLab;
import edu.eci.cvds.servicios.ServiciosLabFactory;


public class App 
{
	
	public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }
	public static void main(String args[]) throws SQLException {
        
        SqlSessionFactory sessionfact = getSqlSessionFactory();

 

        SqlSession sqlss = sessionfact.openSession();
       
       // ServiciosLab sA= ServiciosLabFactory.getInstance().getServiciosLab();

 

        
        //Crear el mapper y usarlo: 
        UsuarioMapper cm= sqlss.getMapper(UsuarioMapper.class);
        //cm...
        System.out.println("Consulta Usuarios");
        System.out.println(cm.consultarUsuarios());
        System.out.println("----------------------");
        System.out.println("----------------------");
       
        /*Date fi = new Date(113,4,5);
        Date ff = new Date(113,5,5);
        cm.agregarItemRentadoACliente(-706, 4, fi, ff);
        System.out.println(cm.consultarCliente(-706));
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("agregar Item");
        ItemMapper im = sqlss.getMapper(ItemMapper.class);
        TipoItem tip = new TipoItem(2, "Accion");
        Date fecha = new Date(116,6,6);
        //Item itemNuevo = new Item(tip, 2122, "BicicletaNo2", "es un medio de transporte", fecha, 100, "Diario", "Accion");
        //im.insertarItem(itemNuevo);
        System.out.println(im.consultarItem(2122));
        */
        sqlss.commit();
        
        
        sqlss.close();

 

        
        
    }

	
}
