package edu.eci.cvds.servicios;

import com.google.inject.Injector;

import edu.eci.cvds.beans.ShiroBean;
import edu.eci.cvds.persistencia.ElementoDAO;
import edu.eci.cvds.persistencia.EquipoDAO;
import edu.eci.cvds.persistencia.LaboratorioDAO;
import edu.eci.cvds.persistencia.NovedadDAO;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisElementoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisEquipoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisLaboratorioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisNovedadDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.servicios.ServiciosECILabImpl;

import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosLabFactory {

    private static ServiciosLabFactory instance = new ServiciosLabFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                
                //binds
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);
                
                

            }
        });
    }

    private  ServiciosLabFactory(){
        optInjector = Optional.empty();
    }

    public ShiroBean detShiroBean(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ShiroBean.class);
    }


    public ServiciosLab getServiciosLabTest(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosLab.class);
    }
    
    public ServiciosLab getServiciosLab(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosLab.class);
    }


    public static ServiciosLabFactory getInstance(){
        return instance;
    }

}