package edu.eci.cvds.guice; 

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.beans.BasePageBean;
import edu.eci.cvds.beans.ServiciosBean;
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
import edu.eci.cvds.security.Logger;
import edu.eci.cvds.security.LoggerApacheShiro;
import edu.eci.cvds.servicios.impl.ServiciosECIElementoImpl;
import edu.eci.cvds.servicios.impl.ServiciosECIEquipoImpl;
import edu.eci.cvds.servicios.impl.ServiciosECILabImpl;
import edu.eci.cvds.servicios.impl.ServiciosECINovedadImpl;
import edu.eci.cvds.servicios.impl.ServiciosECIUserImpl;
import edu.eci.cvds.servicios.ServiciosElemento;
import edu.eci.cvds.servicios.ServiciosEquipo;
import edu.eci.cvds.servicios.ServiciosLab;
import edu.eci.cvds.servicios.ServiciosNovedad;
import edu.eci.cvds.servicios.ServiciosUsuario;



public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.PostgreSQL);

				setEnvironmentId("development");

				setClassPathResource("mybatis-config.xml");

				// Bind
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);
                bind(BasePageBean.class).to(ShiroBean.class);
                bind(Logger.class).to(LoggerApacheShiro.class);
                bind(ServiciosUsuario.class).to(ServiciosECIUserImpl.class);
                bind(ServiciosNovedad.class).to(ServiciosECINovedadImpl.class);
                bind(ServiciosLab.class).to(ServiciosECILabImpl.class);
                bind(ServiciosEquipo.class).to(ServiciosECIEquipoImpl.class);
                bind(ServiciosElemento.class).to(ServiciosECIElementoImpl.class);
			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}