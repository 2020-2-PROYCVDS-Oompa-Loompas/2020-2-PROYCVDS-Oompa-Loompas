package edu.eci.cvds.beans;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.servicios.ExcepcionServiciosLab;
import edu.eci.cvds.servicios.ServiciosElemento;
import edu.eci.cvds.servicios.ServiciosEquipo;
import edu.eci.cvds.servicios.ServiciosLab;
import edu.eci.cvds.servicios.ServiciosNovedad;
import edu.eci.cvds.servicios.ServiciosUsuario;

@ManagedBean(name = "serviciosBean")
@SessionScoped
public class ServiciosBean extends BasePageBean
{
	private static final long serialVersionUID = 5722392954962993428L;
	
	@Inject
	private ServiciosUsuario servicioUsuario;
	@Inject
	private ServiciosLab serviciosLaboratorio;
	@Inject
	private ServiciosNovedad servicioNovedad;
	@Inject
	private ServiciosEquipo servicioEquipo;
	@Inject
	private ServiciosElemento servicioElemento;
	
	private Laboratorio seleccionarLaboratorio;
	private Equipo seleccionarEquipo;
    
	
	
	public void agregarUsuario(String carnet, String nombre, String correo, String contrasena, String estado, String rol) throws PersistenceException
	{
		try
		{
			System.out.println("entra a agregar Usuario");
			System.out.println("carnet "+ carnet);
			System.out.println("nombre "+ nombre);
			servicioUsuario.agregarUsuario(carnet, nombre, correo, contrasena, estado, rol);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Agregar Usuario", "No se pudo agregar el usuario"));
		}
	}
	
	
	public List<Laboratorio> getLaboratorios()
	{
		List<Laboratorio> laboratorios = null;
		
		try
		{
			laboratorios = serviciosLaboratorio.getLaboratorios();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar laboratorios", "No se encuentran laboratorios registrados."));
		}
		return laboratorios;
	}
	
	public Laboratorio getLaboratorioPorNombre(String nombre)
	{
		Laboratorio laboratorio = null;
		
		try
		{
			laboratorio = serviciosLaboratorio.getLaboratorioPorNombre(nombre);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar laboratorio", "No se encuentran el laboratorio " + nombre + "resgistrado."));
		}
		return laboratorio;
	}
	
	public List<Laboratorio> getLaboratoriosDisponibles()
	{
		List<Laboratorio> laboratorios = null;
		
		try
		{
			laboratorios = serviciosLaboratorio.getLaboratoriosDisponibles();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar laboratorios disponibles", "No se encuentran laboratorios disponibles"));
		}
		return laboratorios;
	}
	
	public List<Equipo> getEquiposLaboratorio(String nombre)
	{
		List<Equipo> laboratorios = null;
		try
		{
			laboratorios = serviciosLaboratorio.getEquiposLaboratorio(nombre);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipos del laboratorio", "No se encuentran equipos registrados a este laboratorio"));
		}
		return laboratorios;
	}
	
	public void asociarEquipo(String nombre) throws Exception
	{
		try
		{
			serviciosLaboratorio.asociarEquipo(nombre);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asociar equipo al laboratorio", "No se pudo asociar el equipo a este laboratorio"));
		}
	}
	
	public void cerrarLaboratorio(String nombre, Date fechacierre)
	{
		try
		{
			serviciosLaboratorio.cerrarLaboratorio(nombre, fechacierre);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cerrar laboratorio", "No se pudo cerrar el laboratorio"));
		}
	}
	
	public void agregarLaboratorio(String nombre, int capacidad) throws ExcepcionServiciosLab, PersistenceException 
	{
		try
		{
			serviciosLaboratorio.agregarLaboratorio(nombre, capacidad);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar laboratorio", "No se pudo registrar el laboratorio"));
		}
	}
	
	public void setSeleccionarLaboratorio(Laboratorio laboratorio){
		System.out.println("Entro al set de laboratorio");
		this.seleccionarLaboratorio = laboratorio;
	}

	public Laboratorio getSeleccionarLaboratorio(){
		System.out.println("Entro al get de laboratorio");
		return seleccionarLaboratorio;
	}
	
	public Equipo getEquipo(int id)
	{
		Equipo equipo = null;
		
		try
		{
			equipo = servicioEquipo.getEquipo(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipo", "No se encuentra el equipo registrado"));
		}
		return equipo;
	}
	
	public List<Equipo> getEquipos()
	{
		List<Equipo> equipos = null;
		
		try
		{
			equipos = servicioEquipo.getEquipos();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipos", "No se encuentran los equipos registrados."));
		}
		return equipos;
	}
	
	public void agregarEquipo(String nombre, boolean disponible, boolean funcionamiento, int idlaboratorio) throws PersistenceException
	{
		try
		{
			servicioEquipo.agregarEquipo(nombre, disponible, funcionamiento, idlaboratorio);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Agregar equipo", "No se pudo agregar el equipo"));
		}
	}
	   
	public List<Equipo> getEquiposDisponibles()
	{
		List<Equipo> equipos = null;
		try
		{
			equipos = servicioEquipo.getEquiposDisponibles();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipos disponibles", "No se pudo consultar los equipos disponibles"));
		}
		return equipos;
	}
		
	public void asociarEquipoAlLab(int idlaboratorio, int idequipo) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			System.out.println(idlaboratorio+" id laboratorio beans");
			System.out.println(idequipo+" id equipo beans");
			servicioEquipo.asociarEquipoAlLab(idlaboratorio, idequipo);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipos disponibles", "No se pudo consultar los equipos disponibles"));
		}
		
	}
		
	public void bajarEquipo(int id)
	{
		try
		{
			servicioEquipo.bajarEquipo(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
	}
	
	public void setSeleccionarEquipo(Equipo equipo){
		System.out.println("Entro al set de equipo");
		this.seleccionarEquipo = equipo;
	}

	public Equipo getSeleccionarEquipo(){
		System.out.println("Entro al get de equipo");
		return seleccionarEquipo;
	}
	
	public Elemento getElemento(int id) throws ExcepcionServiciosLab
	{
		Elemento elemento = null;
		
		try
		{
			elemento = servicioElemento.getElemento(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elemento;
	}
	   
	public void agregarElemento(String nombre, String fabricante, boolean disponible, int idequipo) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			servicioElemento.agregarElemento(nombre, fabricante, disponible, idequipo);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
	}
	   
	public List<Elemento> getElementos() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		try
		{
			elementos = servicioElemento.getElementos();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public List<Elemento> getElementoOrdenadoPorId() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementoOrdenadoPorId();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public List<Elemento> getElementoOrdenadoPorCategoria() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementoOrdenadoPorCategoria();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public List<Elemento> getElementoOrdenadoPorFabricante() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementoOrdenadoPorFabricante();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public List<Elemento> getElementoOrdenadoPorDisponible() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementoOrdenadoPorDisponible();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public List<Elemento> getElementoOrdenadoPorIdEquipo() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementoOrdenadoPorIdEquipo();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
	   
	public List<Elemento> getElementosDisponibles() throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementosDisponibles();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public List<Elemento> getElementosPorCategoria(String categoria) throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementoOrdenadoPorCategoria();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
	   
	public List<Elemento> getElementosPorFabricante(String fabricante) throws ExcepcionServiciosLab
	{
		List<Elemento> elementos = null;
		
		try
		{
			elementos = servicioElemento.getElementosPorFabricante(fabricante);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
		return elementos;
	}
		
	public void asociarElemento(int id) throws ExcepcionServiciosLab
	{
		try
		{
			servicioElemento.asociarElemento(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
	}

	public void bajarElemento(int id) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			servicioElemento.bajarElemento(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
	}
	
	public Novedad getNovedad(int id) throws ExcepcionServiciosLab, PersistenceException
	{
		Novedad novedad = null;
		
		try
		{
			novedad = servicioNovedad.getNovedad(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar novedad", "No se pudo encontrar la novedad registrada"));
		}
		return novedad;
	}
	   
	public List<Novedad> getNovedades() throws ExcepcionServiciosLab, PersistenceException
	{
		List<Novedad> novedades = null;
		
		try
		{
			novedades = servicioNovedad.getNovedades();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar novedades", "No se pudo encontrar las novedades registrada"));
		}
		return novedades;
	}
	   
	public void agregarNovedad(Date fecha, int carnet, int idlaboratorio, int idequipo, int idelemento, String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			servicioNovedad.agregarNovedad(fecha, carnet, idlaboratorio, idequipo, idelemento, descripcion, tiponovedad);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar novedad", "No se pudo registrar la novedad"));
		}
	}
	   
	public List<Novedad> getNovedadPorEquipo(int idequipo)throws ExcepcionServiciosLab, PersistenceException
	{
		List<Novedad> novedades = null;
		try
		{
			novedades = servicioNovedad.getNovedadPorEquipo(idequipo);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar novedad por equipo", "No se pudo encontrar la novedad del equipo registrada"));
		}
		return novedades;
	}
		
	public List<Novedad> getNovedadPorElemento(int idelemento)throws ExcepcionServiciosLab, PersistenceException
	{
		List<Novedad> novedades = null;
		try
		{
			novedades = servicioNovedad.getNovedadPorElemento(idelemento);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar novedad por elemento", "No se pudo encontrar la novedad del elemento registrada"));
		}
		return novedades;
	}
	
	public List<Usuario> consultarUsuarios() throws ExcepcionServiciosLab, PersistenceException
	{
		List<Usuario> usuarios = null;
		
		try
		{	
			System.out.println("Entra a consular ");
			usuarios = servicioUsuario.consultarUsuarios();
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar usuarios", "No se pudo encontrar los usuarios registrados"));
		}
		return usuarios;
	}
}
