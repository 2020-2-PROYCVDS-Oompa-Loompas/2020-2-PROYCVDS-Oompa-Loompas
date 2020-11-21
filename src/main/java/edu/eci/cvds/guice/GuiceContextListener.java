package edu.eci.cvds.guice; 

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

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
                
                
			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}