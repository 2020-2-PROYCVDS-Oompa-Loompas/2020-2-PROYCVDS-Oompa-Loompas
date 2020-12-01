package edu.eci.cvds.beans;



import java.util.Date;
import java.util.List;
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
	private Elemento seleccionarElemento;
	
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
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar laboratorio", "Registro del laboratorio exitoso"));
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
	
	public void agregarEquipo(String nombre, String carnet) throws PersistenceException
	{
		try
		{
			servicioEquipo.agregarEquipo(nombre);
			String descripcion = "Se registro el equipo "+nombre+".";
			agregarNovedadDeEquipo(carnet, descripcion, TipoNovedad.REGISTRAR);
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregar equipo", "Registro del equipo exitoso."));
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
		
	public void asociarEquipoAlLab(int idlaboratorio, int idequipo, String carnet, boolean disponible) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			if(disponible)
			{
				servicioEquipo.asociarEquipoAlLab(idlaboratorio, idequipo);
				FacesContext context = FacesContext.getCurrentInstance();
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignar equipo al laboratorio", "Asignacion del equipo exitosa"));
			}
			else
			{
	            String numero = Integer.toString(idequipo);
	    		String descripcion = "Se debe eliminar la asociacion del equipo "+numero+".";
				agregarNovedadAlRegistroLab(carnet, idequipo, descripcion, TipoNovedad.REGISTRAR);
				FacesContext context = FacesContext.getCurrentInstance();
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Novedad", "Se registro la novedad"));
			}
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asignar equipo al laboratorio", "No se pudo asociar el equipo"));
		}
		
	}
		
	private void agregarNovedadAlRegistroLab(String carnet, int idequipo, String descripcion,
			TipoNovedad registrar) {
		servicioNovedad.agregarNovedadAlRegistroLab(carnet, idequipo, descripcion, registrar);
		
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
	
	public void eliminarAsociacionLaboratorio(int idequipo, String carnet) throws ExcepcionServiciosLab, PersistenceException
	{
		servicioEquipo.eliminiarAsociacionLaboratorio(idequipo);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar asociacion del equipo", "Asociacion eliminada"));
		eliminarAsociacionNovedad(idequipo, carnet);
	}
	public void eliminarAsociacionElemento(int id, String carnet) throws ExcepcionServiciosLab, PersistenceException
	{
		servicioElemento.habilitarElemento(id);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar asociacion novedad", "Se genero la novedad"));
        eliminarAsociacionElementoNovedad(id, carnet);
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
	   
	public void agregarElemento(String nombre, String fabricante, String carnet) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			
			servicioElemento.agregarElemento(nombre, fabricante);
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregar Novedad", "Novedad de registro agregada."));
			agregarNovedadElemento(carnet, nombre, fabricante);
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
		
	public void asociarElemento(int idEquipo, String nombre, int elementoId, String carnet) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			String numero = Integer.toString(elementoId);
			String descripcion = "Se registra la asociacion del elemento "+numero+".";
			
			String categoria = servicioElemento.getElemento(elementoId).getCategoria();
			List<Elemento> listaElementoTorres = servicioElemento.getElementosPorCategoria(categoria);
			System.out.println("tamanio");
			System.out.println(nombre);
			System.out.println(listaElementoTorres.size());
			for(int i=0; i < listaElementoTorres.size(); i++) {
				System.out.println("nombreEquipos");
				System.out.println(listaElementoTorres.get(i).getEquipo());
				if(listaElementoTorres.get(i).getEquipo() != null && listaElementoTorres.get(i).getEquipo().equals(nombre)) {
					System.out.println("entro");
					int idEsp = listaElementoTorres.get(i).getId();
					servicioElemento.habilitarElemento(idEsp);
					String descripcion2 = "Se reemplazo el elemento " + categoria + " "+ idEsp + "por el elemento " + categoria + " " + elementoId;
					agregarNovedadAlAsociarElemento(carnet, idEquipo, elementoId,descripcion2, TipoNovedad.REEMPLAZAR);
				}
			}	
			servicioElemento.asociarElemento(nombre, elementoId);
			agregarNovedadAlAsociarElemento(carnet, idEquipo, elementoId,descripcion, TipoNovedad.REGISTRAR);
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociar Elemento", "Asociación del elemento exitosa"));
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asociar Elemento", "No se pudo asociar el elemento"));
		}
	}

	private void agregarNovedadAlAsociarElemento(String carnet, int idEquipo, int idElemento, String descripcion,
			TipoNovedad registrar) {
		servicioNovedad.agregarNovedadAlAsociarElemento(carnet, idEquipo, idElemento,descripcion, registrar);
		
	}

	public void bajarElemento(int id) throws ExcepcionServiciosLab, PersistenceException
	{
		try
		{
			System.out.println("El id es: "+id);
			servicioElemento.bajarElemento(id);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bajar equipo", "No se pudo dar de baja al equipo"));
		}
	}
	
	public void setSeleccionarElemento(Elemento elemento){
		System.out.println("Entro al set de elemento");
		this.seleccionarElemento = elemento;
	}

	public Elemento getSeleccionarElemento(){
		System.out.println("Entro al get de elemento");
		return seleccionarElemento;
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
	   
	public void agregarNovedad(Date fecha, String carnet, int idlaboratorio, int idequipo, int idelemento, String descripcion, TipoNovedad tiponovedad) throws ExcepcionServiciosLab, PersistenceException
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
	
	public void agregarNovedadAsociacion(String carnet, int idequipo, String descripcion, TipoNovedad tipoNovedad) throws PersistenceException
	{
		try
		{
			servicioNovedad.agregarNovedadAsociacion(carnet, idequipo, descripcion, tipoNovedad);
		} catch(ExcepcionServiciosLab e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar novedad", "No se pudo agregar la novedad"));
		}
	}
	
	private void agregarNovedadDeEquipo(String carnet, String descripcion, TipoNovedad registrar) throws ExcepcionServiciosLab
	{
		servicioNovedad.agregarNovedadDeEquipo(carnet, descripcion, registrar);
	}
	
	private void agregarNovedadElemento(String carnet, String nombre, String fabricante) throws ExcepcionServiciosLab
	{
		String descripcion = "Se registro el elemento " + nombre + "y su fabricante " + fabricante + ".";
		servicioNovedad.agregarNovedadElemento(carnet, descripcion, TipoNovedad.REGISTRAR);
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
	
	@SuppressWarnings("null")
	public void eliminarAsociacionNovedad(int idequipo, String carnet) throws ExcepcionServiciosLab, PersistenceException
	{
		String numero = Integer.toString(idequipo);
		String descripcion = "Se elimino la asociacion del equipo "+numero+".";
		agregarNovedadAsociacion(carnet, idequipo, descripcion, TipoNovedad.ELIMINAR);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Novedad", "Se registro la novedad"));
	}
	
	@SuppressWarnings("null")
	public void eliminarAsociacionElementoNovedad(int idequipo, String carnet) throws ExcepcionServiciosLab, PersistenceException
	{
		String numero = Integer.toString(idequipo);
		String descripcion = "Se elimino la asociacion del elemento "+numero+".";
		agregarNovedadElemeto(carnet, idequipo, descripcion, TipoNovedad.ELIMINAR);
	}
	
	public void agregarNovedadElemeto(String carnet, int id, String descripcion, TipoNovedad tipoNovedad) throws PersistenceException {
		servicioNovedad.agregarNovedadEliminarAscElemento(carnet, id, descripcion, tipoNovedad);
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
