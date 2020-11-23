package edu.eci.cvds;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.ElementoMapper;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.EquipoMapper;
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
        EquipoMapper eqm = sqlss.getMapper(EquipoMapper.class);
        //cm...
        System.out.println("Consulta Usuarios");
        System.out.println(cm.consultarUsuarios());
        System.out.println("----------------------");
        System.out.println("----------------------");
		System.out.println("Consulta las novedades");
		System.out.println(nm.getNovedades());
		System.out.println("----------------------");
        System.out.println("----------------------");
		System.out.println("Consulta las novedades por equipo");
		System.out.println(nm.getNovedadPorEquipo(1));
		System.out.println("----------------------");
        System.out.println("----------------------");
		System.out.println("Consulta las novedades por elemento");
		System.out.println(nm.getNovedadPorElemento(1));
		System.out.println("----------------------");
        System.out.println("----------------------");
		System.out.println("Consulta el laboratorio según su id");
		System.out.println(lm.getLaboratorio(1));
		System.out.println("----------------------");
        System.out.println("----------------------");
		System.out.println("Consulta los laboratorios");
		System.out.println(lm.getLaboratorios());
		System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consulta los laboratorios disponibles");
		System.out.println(lm.getLaboratoriosDisponibles());
		System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consulta los equipos de un laboratorio");
		System.out.println(lm.getEquiposLaboratorio(1));
		System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos disponibles");
        System.out.println(em.getElementosDisponible());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Dar de baja a un elemento");
        em.bajarElemento(9);
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos");
        System.out.println(em.getElementos());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos por categoria");
        System.out.println(em.getElementosPorCategoria("Torre"));
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos por fabricante");
        System.out.println(em.getElementosPorFabricante("Microsoft"));
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos ordenados por id");
        System.out.println(em.getElementoOrdenadoPorId());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos ordenados por categoria");
        System.out.println(em.getElementoOrdenadoPorCategoria());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos ordenados por fabricante");
        System.out.println(em.getElementoOrdenadoPorFabricante());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos ordenados por disponible");
        System.out.println(em.getElementoOrdenadoPorDisponible());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consultar los elementos ordenados por id equipo");
        System.out.println(em.getElementoOrdenadoPorIdEquipo());
        System.out.println("----------------------");
        System.out.println("----------------------");
        //System.out.println("Registrar Laboratorio");
        //lm.agregarLaboratorio("Seguridad", 10, true);
		//System.out.println("--Laboratorio agregado--");
        //System.out.println("----------------------");
        //System.out.println("Registrar Equipo");
        //eqm.agregarEquipo("Computador", true);
        //System.out.println("--Equipo Agregado--");
        //System.out.println("Registrar Novedad");
        //LocalDate fecha = LocalDate.now();
        //nm.agregarNovedad(fecha, 2123238, 1, 1, "Se realiza una consulta sobre el equipo y sus elementos", TipoNovedad.CONSULTAR);
        //System.out.println("--Novedad Agregada--");

        
        
       

        sqlss.commit();
        
        
        sqlss.close();

 

        
        
    }

	
}
