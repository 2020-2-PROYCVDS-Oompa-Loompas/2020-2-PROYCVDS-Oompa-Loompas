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
import edu.eci.cvds.persistencia.mybatisimpl.mappers.ElementoMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.LaboratorioMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.NovedadMapper;
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
        NovedadMapper nm = sqlss.getMapper(NovedadMapper.class);
        LaboratorioMapper lm = sqlss.getMapper(LaboratorioMapper.class);
        ElementoMapper em = sqlss.getMapper(ElementoMapper.class);
        //cm...
        System.out.println("Consulta Usuarios");
        System.out.println(cm.consultarUsuarios());
        System.out.println("----------------------");
        System.out.println("----------------------");
		System.out.println("Consulta las novedades");
		System.out.println(nm.getNovedades());
		System.out.println("----------------------");
        System.out.println("----------------------");
        //System.out.println("Insertar Laboratorio");
		//lm.agregarLaboratorio(2, "Lab. Redes", 15);
		//System.out.println("--Laboratorio agregado--");
        System.out.println("Registrar Elemento");
        em.agregarElemento(1, "HP", 0, true, "Teclado");
        System.out.println("--Elemento Agregado--");
        System.out.println("----------------------");
       

        sqlss.commit();
        
        
        sqlss.close();

 

        
        
    }

	
}
