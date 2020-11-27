package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoNovedad;

public interface NovedadMapper
{	
	public Novedad getNovedad(@Param("idNov") int id);	
	
	public List<Novedad> getNovedades();
	
	public void agregarNovedad(@Param("fecha") Date fecha, @Param("carnet") String carnet, @Param("idequipo") int idequipo, @Param("idelemento") int idelemento, @Param("descripcion") String descripcion, @Param("tiponovedad") TipoNovedad tiponovedad);
	
	public void agregarNovedadAsociacion(@Param("carnet") String carnet, @Param("idequipo") int idequipo, @Param("descripcion") String descripcion, @Param("tiponovedad") TipoNovedad tiponovedad);
	
	public void agregarNovedadAlRegistroLab(@Param("carnet") String carnet, @Param("idequipo") int idequipo, @Param("descripcion") String descripcion,
			@Param("registrar") TipoNovedad registrar);
	
	public List<Novedad> getNovedadPorEquipo(@Param("idequipo") int id);	
	
	public List<Novedad> getNovedadPorElemento(@Param("idelemento") int id);	
}